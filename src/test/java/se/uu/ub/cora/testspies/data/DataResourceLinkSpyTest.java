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

public class DataResourceLinkSpyTest {
	DataResourceLinkSpy dataResourceLink;
	private MethodCallRecorder MCR;
	private MethodReturnValues MRV;

	@BeforeMethod
	public void beforeMethod() {
		dataResourceLink = new DataResourceLinkSpy();
		MCR = dataResourceLink.MCR;
		MRV = dataResourceLink.MRV;
	}

	@Test
	public void testMakeSureMCRExists() throws Exception {
		assertTrue(dataResourceLink.MCR instanceof MethodCallRecorder);
	}

	@Test
	public void testMakeSureMRVExists() throws Exception {
		assertTrue(dataResourceLink.MRV instanceof MethodReturnValues);
	}

	@Test
	public void testStreamId() throws Exception {
		dataResourceLink.setStreamId("stream");
		MCR.assertParameter("setStreamId", 0, "streamId", "stream");
	}

	@Test
	public void getStreamId() throws Exception {
		MRV.setReturnValues("getStreamId", List.of("firstId"));

		dataResourceLink.getStreamId();

		MCR.assertParameters("getStreamId", 0);
		MCR.assertReturn("getStreamId", 0, "firstId");
	}

	@Test
	public void testFilename() throws Exception {
		dataResourceLink.setFileName("fileN");
		MCR.assertParameter("setFileName", 0, "fileName", "fileN");
	}

	@Test
	public void getFileName() throws Exception {
		MRV.setReturnValues("getFileName", List.of("filename2"));

		dataResourceLink.getFileName();

		MCR.assertParameters("getFileName", 0);
		MCR.assertReturn("getFileName", 0, "filename2");
	}

	@Test
	public void testFileSize() throws Exception {
		dataResourceLink.setFileSize("1234");
		MCR.assertParameter("setFileSize", 0, "fileSize", "1234");
	}

	@Test
	public void getFileSize() throws Exception {
		MRV.setReturnValues("getFileSize", List.of("filesize2"));

		dataResourceLink.getFileSize();

		MCR.assertParameters("getFileSize", 0);
		MCR.assertReturn("getFileSize", 0, "filesize2");
	}

	@Test
	public void testMimeType() throws Exception {
		dataResourceLink.setMimeType("bla");
		MCR.assertParameter("setMimeType", 0, "mimeType", "bla");
	}

	@Test
	public void getMimeType() throws Exception {
		MRV.setReturnValues("getMimeType", List.of("MimeType2"));

		dataResourceLink.getMimeType();

		MCR.assertParameters("getMimeType", 0);
		MCR.assertReturn("getMimeType", 0, "MimeType2");
	}

}
