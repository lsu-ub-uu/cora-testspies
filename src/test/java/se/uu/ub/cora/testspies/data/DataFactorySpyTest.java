/*
 * Copyright 2022 Olov McKie
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.cora.testspies.data;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class DataFactorySpyTest {
	DataFactorySpy dataFactory;
	MethodCallRecorder MCR;
	MethodReturnValues MRV;

	@BeforeMethod
	public void beforeMethod() {
		dataFactory = new DataFactorySpy();
		MCR = dataFactory.MCR;
		MRV = dataFactory.MRV;
	}

	@Test
	public void testMakeSureMCRExists() throws Exception {
		assertTrue(MCR instanceof MethodCallRecorder);
	}

	@Test
	public void testMakeSureMRVExists() throws Exception {
		assertTrue(MRV instanceof MethodReturnValues);
	}

	@Test
	public void testFactorListUsingNameOfDataType() throws Exception {
		dataFactory.factorListUsingNameOfDataType("aValue");

		MCR.assertParameter("factorListUsingNameOfDataType", 0, "nameOfDataType", "aValue");
	}

	@Test
	public void testFactorGroupUsingNameInData() throws Exception {
		DataGroupSpy e1 = new DataGroupSpy();
		dataFactory.MRV.setReturnValues("factorGroupUsingNameInData", List.of(e1), "aName");
		dataFactory.factorGroupUsingNameInData("aName");

		MCR.assertParameter("factorGroupUsingNameInData", 0, "nameInData", "aName");
		MCR.assertReturn("factorGroupUsingNameInData", 0, e1);
	}

	@Test
	public void testFactorRecordLinkUsingNameInDataAndTypeAndId() throws Exception {
		dataFactory.factorRecordLinkUsingNameInDataAndTypeAndId("nameInData", "aType", "aRecordId");

		MCR.assertParameter("factorRecordLinkUsingNameInDataAndTypeAndId", 0, "nameInData",
				"nameInData");
		MCR.assertParameter("factorRecordLinkUsingNameInDataAndTypeAndId", 0, "recordType",
				"aType");
		MCR.assertParameter("factorRecordLinkUsingNameInDataAndTypeAndId", 0, "recordId",
				"aRecordId");
		DataRecordLinkSpy dataRecordLink = (DataRecordLinkSpy) MCR
				.getReturnValue("factorRecordLinkUsingNameInDataAndTypeAndId", 0);
		assertTrue(dataRecordLink instanceof DataRecordLinkSpy);
	}

	@Test
	public void testFactorResourceLinkUsingNameInData() throws Exception {
		dataFactory.factorResourceLinkUsingNameInData("nameInData");

		MCR.assertParameter("factorResourceLinkUsingNameInData", 0, "nameInData", "nameInData");
		DataResourceLinkSpy dataRecordLink = (DataResourceLinkSpy) MCR
				.getReturnValue("factorResourceLinkUsingNameInData", 0);
		assertTrue(dataRecordLink instanceof DataResourceLinkSpy);
	}

	@Test
	public void testFactorAtomicUsingNameInDataAndValue() throws Exception {
		dataFactory.factorAtomicUsingNameInDataAndValue("aName", "aValue");

		MCR.assertParameter("factorAtomicUsingNameInDataAndValue", 0, "nameInData", "aName");
		MCR.assertParameter("factorAtomicUsingNameInDataAndValue", 0, "value", "aValue");
		DataAtomicSpy dataAtomic = (DataAtomicSpy) MCR
				.getReturnValue("factorAtomicUsingNameInDataAndValue", 0);
		assertTrue(dataAtomic instanceof DataAtomicSpy);
	}
}
