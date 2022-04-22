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

import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.testspies.spy.MCRSpy;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class DataRecordSpyTest {
	private static final String ADD_CALL = "addCall";
	private static final String ADD_CALL_AND_RETURN_FROM_MRV = "addCallAndReturnFromMRV";
	DataRecordSpy dataRecord;
	private MCRSpy MCRSpy;
	private MethodCallRecorder mcrForSpy;

	@BeforeMethod
	public void beforeMethod() {
		MCRSpy = new MCRSpy();
		mcrForSpy = MCRSpy.MCR;
		dataRecord = new DataRecordSpy();
	}

	@Test
	public void testMakeSureSpyHelpersAreSetUp() throws Exception {
		assertTrue(dataRecord.MCR instanceof MethodCallRecorder);
		assertTrue(dataRecord.MRV instanceof MethodReturnValues);
		assertSame(dataRecord.MCR.onlyForTestGetMRV(), dataRecord.MRV);
	}

	@Test
	public void testDefaultGetType() throws Exception {
		assertTrue(dataRecord.getType() instanceof String);
	}

	@Test
	public void testGetType() throws Exception {
		dataRecord.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		String returnedValue = dataRecord.getType();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultGetId() throws Exception {
		assertTrue(dataRecord.getId() instanceof String);
	}

	@Test
	public void testGetId() throws Exception {
		dataRecord.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		String returnedValue = dataRecord.getId();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testSetDataGroup() throws Exception {
		dataRecord.MCR = MCRSpy;
		DataGroupSpy dataGroup = new DataGroupSpy();

		dataRecord.setDataGroup(dataGroup);

		mcrForSpy.assertParameter(ADD_CALL, 0, "dataGroup", dataGroup);
	}

	@Test
	public void testDefaultGetDataGroup() throws Exception {
		assertTrue(dataRecord.getDataGroup() instanceof DataGroupSpy);
	}

	@Test
	public void testGetDataGroup() throws Exception {
		dataRecord.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, DataGroupSpy::new);

		var returnedValue = dataRecord.getDataGroup();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	// TODO:addAction
	// TODO:hasActions
	// TODO:getActions
	// TODO:addReadPermission
	// TODO:addReadPermissions
	// TODO:getReadPermissions
	// TODO:hasReadPermissions
	// TODO:addWritePermission
	// TODO:addWritePermissions
	// TODO:getWritePermissions
	// TODO:hasWritePermissions
	@Test
	public void testDefaultGetSearchId() throws Exception {
		assertTrue(dataRecord.getSearchId() instanceof String);
	}

	@Test
	public void testGetSearchId() throws Exception {
		dataRecord.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		String returnedValue = dataRecord.getSearchId();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}
}
