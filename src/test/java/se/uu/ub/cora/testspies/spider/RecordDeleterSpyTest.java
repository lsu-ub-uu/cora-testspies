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
package se.uu.ub.cora.testspies.spider;

import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.testspies.spy.MCRSpy;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class RecordDeleterSpyTest {

	private static final String ADD_CALL = "addCall";
	private static final String ADD_CALL_AND_RETURN_FROM_MRV = "addCallAndReturnFromMRV";
	RecordDeleterSpy recordDeleter;
	private MCRSpy MCRSpy;
	private MethodCallRecorder mcrForSpy;

	@BeforeMethod
	public void beforeMethod() {
		MCRSpy = new MCRSpy();
		mcrForSpy = MCRSpy.MCR;
		recordDeleter = new RecordDeleterSpy();
	}

	@Test
	public void testMakeSureSpyHelpersAreSetUp() throws Exception {
		assertTrue(recordDeleter.MCR instanceof MethodCallRecorder);
		assertTrue(recordDeleter.MRV instanceof MethodReturnValues);
		assertSame(recordDeleter.MCR.onlyForTestGetMRV(), recordDeleter.MRV);
	}

	@Test
	public void testDeleteRecord() throws Exception {
		recordDeleter.MCR = MCRSpy;

		recordDeleter.deleteRecord("authToken", "type", "id");

		mcrForSpy.assertMethodWasCalled(ADD_CALL);
		mcrForSpy.assertParameter(ADD_CALL, 0, "authToken", "authToken");
		mcrForSpy.assertParameter(ADD_CALL, 0, "type", "type");
		mcrForSpy.assertParameter(ADD_CALL, 0, "id", "id");
	}

}