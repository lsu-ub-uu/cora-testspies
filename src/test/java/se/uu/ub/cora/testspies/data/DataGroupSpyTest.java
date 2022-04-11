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

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;

public class DataGroupSpyTest {
	DataGroupSpy dataGroup;

	@BeforeMethod
	public void beforeMethod() {
		dataGroup = new DataGroupSpy();
	}

	@Test
	public void testMakeSureMCRExists() throws Exception {
		assertTrue(dataGroup.MCR instanceof MethodCallRecorder);
	}

	@Test
	public void testAddChild() throws Exception {
		DataElementSpy dataElement = new DataElementSpy();
		dataGroup.addChild(dataElement);

		dataGroup.MCR.assertParameter("addChild", 0, "dataElement", dataElement);
	}
}
