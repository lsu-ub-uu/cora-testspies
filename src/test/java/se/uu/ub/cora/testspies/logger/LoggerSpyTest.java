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
package se.uu.ub.cora.testspies.logger;

import static org.testng.Assert.assertTrue;

import java.util.function.Supplier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.testspies.spy.MCRSpy;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;

public class LoggerSpyTest {
	private static final String ADD_CALL = "addCall";
	LoggerSpy logger;
	private MCRSpy MCRSpy;
	private MethodCallRecorder mcrForSpy;

	@BeforeMethod
	public void beforeMethod() {
		MCRSpy = new MCRSpy();
		mcrForSpy = MCRSpy.MCR;
		logger = new LoggerSpy();
	}

	@Test
	public void testMakeSureSpyHelpersAreSetUp() throws Exception {
		assertTrue(logger.MCR instanceof MethodCallRecorder);
	}

	@Test
	public void testLogFatalUsingMessage() throws Exception {
		logger.MCR = MCRSpy;

		logger.logFatalUsingMessage("someMessage");

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
	}

	@Test
	public void testLogFatalUsingMessageAndException() throws Exception {
		logger.MCR = MCRSpy;
		RuntimeException exception = new RuntimeException();

		logger.logFatalUsingMessageAndException("someMessage", exception);

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
		mcrForSpy.assertParameter(ADD_CALL, 0, "exception", exception);
	}

	@Test
	public void testLogErrorUsingMessage() throws Exception {
		logger.MCR = MCRSpy;

		logger.logErrorUsingMessage("someMessage");

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
	}

	@Test
	public void testLogErrorUsingMessageAndException() throws Exception {
		logger.MCR = MCRSpy;
		RuntimeException exception = new RuntimeException();

		logger.logErrorUsingMessageAndException("someMessage", exception);

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
		mcrForSpy.assertParameter(ADD_CALL, 0, "exception", exception);
	}

	@Test
	public void testLogWarnUsingMessage() throws Exception {
		logger.MCR = MCRSpy;

		logger.logWarnUsingMessage("someMessage");

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
	}

	@Test
	public void testLogWarnUsingMessageAndException() throws Exception {
		logger.MCR = MCRSpy;
		RuntimeException exception = new RuntimeException();

		logger.logWarnUsingMessageAndException("someMessage", exception);

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
		mcrForSpy.assertParameter(ADD_CALL, 0, "exception", exception);
	}

	@Test
	public void testLogInfoUsingMessage() throws Exception {
		logger.MCR = MCRSpy;

		logger.logInfoUsingMessage("someMessage");

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
	}

	@Test
	public void testDebugInfoUsingMessage() throws Exception {
		logger.MCR = MCRSpy;

		logger.logDebugUsingMessage("someMessage");

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
	}

	@Test
	public void testLogDebugUsingMessageSupplier() throws Exception {
		logger.MCR = MCRSpy;
		Supplier<String> messageSupplier = String::new;

		logger.logDebugUsingMessageSupplier(messageSupplier);

		mcrForSpy.assertParameter(ADD_CALL, 0, "messageSupplier", messageSupplier);
	}

	@Test
	public void testTraceInfoUsingMessage() throws Exception {
		logger.MCR = MCRSpy;

		logger.logTraceUsingMessage("someMessage");

		mcrForSpy.assertParameter(ADD_CALL, 0, "message", "someMessage");
	}

	@Test
	public void testLogTraceUsingMessageSupplier() throws Exception {
		logger.MCR = MCRSpy;
		Supplier<String> messageSupplier = String::new;

		logger.logTraceUsingMessageSupplier(messageSupplier);

		mcrForSpy.assertParameter(ADD_CALL, 0, "messageSupplier", messageSupplier);
	}

}
