/*
 * Copyright 2022 Uppsala University Library
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
package se.uu.ub.cora.testspies.httphandler;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.io.InputStream;
import java.util.function.Supplier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;
import se.uu.ub.cora.testutils.spies.MCRSpy;

public class HttpHandlerSpyTest {

	private static final String ADD_CALL = "addCall";
	private static final String ADD_CALL_AND_RETURN_FROM_MRV = "addCallAndReturnFromMRV";
	HttpHandlerSpy httpHandler;
	private MCRSpy MCRSpy;
	private MethodCallRecorder mcrForSpy;

	@BeforeMethod
	public void beforeMethod() {
		MCRSpy = new MCRSpy();
		mcrForSpy = MCRSpy.MCR;
		httpHandler = new HttpHandlerSpy();
	}

	@Test
	public void testMakeSureSpyHelpersAreSetUp() throws Exception {
		assertTrue(httpHandler.MCR instanceof MethodCallRecorder);
		assertTrue(httpHandler.MRV instanceof MethodReturnValues);
		assertSame(httpHandler.MCR.onlyForTestGetMRV(), httpHandler.MRV);
	}

	@Test
	public void testSetRequestMethod() throws Exception {
		httpHandler.MCR = MCRSpy;

		httpHandler.setRequestMethod("requestMethod");

		mcrForSpy.assertMethodWasCalled(ADD_CALL);
		mcrForSpy.assertParameter(ADD_CALL, 0, "requestMethod", "requestMethod");
	}

	@Test
	public void testDefaultGetResponseText() throws Exception {
		assertTrue(httpHandler.getResponseText() instanceof String);
	}

	@Test
	public void testGetResponseText() throws Exception {
		httpHandler.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		var returnedValue = httpHandler.getResponseText();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultGetResponseCode() throws Exception {
		assertEquals(httpHandler.getResponseCode(), 200);
	}

	@Test
	public void testGetResponseCode() throws Exception {
		httpHandler.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				((Supplier<?>) () -> 400));

		var returnedValue = httpHandler.getResponseCode();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testSetOutput() throws Exception {
		httpHandler.MCR = MCRSpy;

		httpHandler.setOutput("outputString");

		mcrForSpy.assertMethodWasCalled(ADD_CALL);
		mcrForSpy.assertParameter(ADD_CALL, 0, "outputString", "outputString");
	}

	@Test
	public void testRequestProperty() throws Exception {
		httpHandler.MCR = MCRSpy;

		httpHandler.setRequestProperty("key", "value");

		mcrForSpy.assertMethodWasCalled(ADD_CALL);
		mcrForSpy.assertParameter(ADD_CALL, 0, "key", "key");
		mcrForSpy.assertParameter(ADD_CALL, 0, "value", "value");
	}

	@Test
	public void testDefaultGetErrorText() throws Exception {
		assertTrue(httpHandler.getErrorText() instanceof String);
	}

	@Test
	public void testGetErrorText() throws Exception {
		httpHandler.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		var returnedValue = httpHandler.getErrorText();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testSetStreamOutput() throws Exception {
		httpHandler.MCR = MCRSpy;

		InputStream stream = new InputStreamSpy();
		httpHandler.setStreamOutput(stream);

		mcrForSpy.assertMethodWasCalled(ADD_CALL);
		mcrForSpy.assertParameter(ADD_CALL, 0, "stream", stream);
	}

	@Test
	public void testDefaultGetHeaderField() throws Exception {
		assertTrue(httpHandler.getHeaderField("name") instanceof String);
	}

	@Test
	public void testGetHeaderField() throws Exception {
		httpHandler.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		var returnedValue = httpHandler.getHeaderField("name");

		mcrForSpy.assertParameter(ADD_CALL_AND_RETURN_FROM_MRV, 0, "name", "name");
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testSetBasicAuthorization() throws Exception {
		httpHandler.MCR = MCRSpy;

		httpHandler.setBasicAuthorization("username", "password");

		mcrForSpy.assertMethodWasCalled(ADD_CALL);
		mcrForSpy.assertParameter(ADD_CALL, 0, "username", "username");
		mcrForSpy.assertParameter(ADD_CALL, 0, "password", "password");
	}

	@Test
	public void testDefaultGetResponseBinary() throws Exception {
		assertTrue(httpHandler.getResponseBinary() instanceof InputStreamSpy);
	}

	@Test
	public void testGetResponseBinary() throws Exception {
		httpHandler.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				InputStreamSpy::new);

		var returnedValue = httpHandler.getResponseBinary();

		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

}
