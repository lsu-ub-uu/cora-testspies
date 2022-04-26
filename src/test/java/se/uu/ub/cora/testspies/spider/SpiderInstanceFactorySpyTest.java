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

public class SpiderInstanceFactorySpyTest {
	private static final String ADD_CALL = "addCall";
	private static final String ADD_CALL_AND_RETURN_FROM_MRV = "addCallAndReturnFromMRV";
	SpiderInstanceFactorySpy instanceFactory;
	private MCRSpy MCRSpy;
	private MethodCallRecorder mcrForSpy;

	@BeforeMethod
	public void beforeMethod() {
		MCRSpy = new MCRSpy();
		mcrForSpy = MCRSpy.MCR;
		instanceFactory = new SpiderInstanceFactorySpy();
	}

	@Test
	public void testMakeSureSpyHelpersAreSetUp() throws Exception {
		assertTrue(instanceFactory.MCR instanceof MethodCallRecorder);
		assertTrue(instanceFactory.MRV instanceof MethodReturnValues);
		assertSame(instanceFactory.MCR.onlyForTestGetMRV(), instanceFactory.MRV);
	}

	@Test
	public void testDefaultDependencyProviderClassName() throws Exception {
		assertTrue(instanceFactory.getDependencyProviderClassName() instanceof String);
	}

	@Test
	public void testGetDependencyProviderClassName() throws Exception {
		instanceFactory.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV, String::new);

		String returnedValue = instanceFactory.getDependencyProviderClassName();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultFactorRecordReader() throws Exception {
		assertTrue(instanceFactory.factorRecordReader() instanceof RecordReaderSpy);
	}

	@Test
	public void testFactorRecordReader() throws Exception {
		instanceFactory.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				RecordReaderSpy::new);

		var returnedValue = instanceFactory.factorRecordReader();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}
	// TODO://factorIncomingLinksReader
	// TODO://factorRecordListReader

	@Test
	public void testDefaultFactorRecordCreator() throws Exception {
		assertTrue(instanceFactory.factorRecordCreator() instanceof RecordCreatorSpy);
	}

	@Test
	public void testFactorRecordCreator() throws Exception {
		instanceFactory.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				RecordCreatorSpy::new);

		var returnedValue = instanceFactory.factorRecordCreator();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	@Test
	public void testDefaultFactorRecordUpdater() throws Exception {
		assertTrue(instanceFactory.factorRecordUpdater() instanceof RecordUpdaterSpy);
	}

	@Test
	public void testFactorRecordUpdater() throws Exception {
		instanceFactory.MCR = MCRSpy;
		MCRSpy.MRV.setDefaultReturnValuesSupplier(ADD_CALL_AND_RETURN_FROM_MRV,
				RecordUpdaterSpy::new);

		var returnedValue = instanceFactory.factorRecordUpdater();

		mcrForSpy.assertMethodWasCalled(ADD_CALL_AND_RETURN_FROM_MRV);
		mcrForSpy.assertReturn(ADD_CALL_AND_RETURN_FROM_MRV, 0, returnedValue);
	}

	// TODO://factorRecordDeleter
	// TODO://factorUploader
	// TODO://factorRecordSearcher
	// TODO://factorRecordValidator
	// TODO://factorRecordListIndexer

}
