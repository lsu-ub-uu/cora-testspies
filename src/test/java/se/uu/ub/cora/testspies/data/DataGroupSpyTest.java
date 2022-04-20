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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.data.DataAttribute;
import se.uu.ub.cora.data.DataChild;
import se.uu.ub.cora.testspies.spy.MCRSpy;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class DataGroupSpyTest {
	private static final String ADD_CALL = "addCall";
	private static final String ADD_CALL_AND_RETURN_FROM_MRV = "addCallAndReturnFromMRV";
	DataGroupSpy dataGroup;
	private MCRSpy MCRSpy;
	private MethodCallRecorder mcrForSpy;

	@BeforeMethod
	public void beforeMethod() {
		MCRSpy = new MCRSpy();
		mcrForSpy = MCRSpy.MCR;
		dataGroup = new DataGroupSpy();
	}

	@Test
	public void testMakeSureSpyHelpersAreSetUp() throws Exception {
		assertTrue(dataGroup.MCR instanceof MethodCallRecorder);
		assertTrue(dataGroup.MRV instanceof MethodReturnValues);
		assertSame(dataGroup.MCR.onlyForTestGetMRV(), dataGroup.MRV);
	}

	@Test
	public void testAddChildNoSpy() throws Exception {
		DataChildSpy dataChild = new DataChildSpy();
		dataGroup.addChild(dataChild);

		dataGroup.MCR.assertParameter("addChild", 0, "dataChild", dataChild);
	}

	@Test
	public void testSetRepeatId() throws Exception {
		dataGroup.MCR = MCRSpy;

		dataGroup.setRepeatId("repeat1");

		mcrForSpy.assertParameter(ADD_CALL, 0, "repeatId", "repeat1");
	}

	@Test
	public void testDefaultGetRepeatId() throws Exception {
		assertTrue(dataGroup.getRepeatId() instanceof String);
	}

	@Test
	public void testGetRepeatId() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		String returnedValue = dataGroup.getRepeatId();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testAddAttributeByIdWithValue() throws Exception {
		dataGroup.MCR = MCRSpy;

		dataGroup.addAttributeByIdWithValue("attribId", "attribValue");

		mcrForSpy.assertParameter(ADD_CALL, 0, "nameInData", "attribId");
		mcrForSpy.assertParameter(ADD_CALL, 0, "value", "attribValue");
	}

	@Test
	public void testDefaultHasAttributes() throws Exception {
		assertFalse(dataGroup.hasAttributes());
	}

	@Test
	public void testHasAttributes() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				(Supplier<Boolean>) () -> true);

		boolean retunedValue = dataGroup.hasAttributes();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, retunedValue);
	}

	@Test
	public void testDefaultGetAttribute() throws Exception {
		assertTrue(dataGroup.getAttribute("nameInData") instanceof DataAttribute);
	}

	@Test
	public void testGetAttribute() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				DataAttributeSpy::new);

		var returnedValue = dataGroup.getAttribute("nameInData");

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertParameter(ADD_CALL_AND_RETURN_FROM_MRV, 0, "nameInData", "nameInData");
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultGetAttributes() throws Exception {
		assertTrue(dataGroup.getAttributes() instanceof Collection<DataAttribute>);
	}

	@Test
	public void testGetAttributes() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				ArrayList<DataAttribute>::new);

		var returnedValue = dataGroup.getAttributes();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultGetNameInData() throws Exception {
		assertTrue(dataGroup.getNameInData() instanceof String);
	}

	@Test
	public void testGetNameInData() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		String returnedValue = dataGroup.getNameInData();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultHasChildren() throws Exception {
		assertTrue(dataGroup.hasChildren());
	}

	@Test
	public void testHasChildren() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				(Supplier<Boolean>) () -> false);

		boolean retunedValue = dataGroup.hasChildren();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, retunedValue);
	}

	@Test
	public void testDefaultContainsChildWithNameInData() throws Exception {
		assertFalse(dataGroup.containsChildWithNameInData("nameInData"));
	}

	@Test
	public void testContainsChildWithNameInData() throws Exception {
		dataGroup.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				(Supplier<Boolean>) () -> false);

		boolean retunedValue = dataGroup.containsChildWithNameInData("nameInData");

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertParameter(ADD_CALL_AND_RETURN_FROM_MRV, 0, "nameInData", "nameInData");
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, retunedValue);
	}

	@Test
	public void testAddChild() throws Exception {
		DataChildSpy dataChild = new DataChildSpy();
		dataGroup.MCR = MCRSpy;

		dataGroup.addChild(dataChild);

		mcrForSpy.assertParameter(ADD_CALL, 0, "dataChild", dataChild);
	}

	@Test
	public void testAddChildren() throws Exception {
		Collection<DataChild> children = new ArrayList<>();
		dataGroup.MCR = MCRSpy;

		dataGroup.addChildren(children);

		mcrForSpy.assertParameter(ADD_CALL, 0, "dataChildren", children);
	}
}
