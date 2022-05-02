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

import java.io.InputStream;
import java.util.function.Supplier;

import se.uu.ub.cora.httphandler.HttpHandler;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class HttpHandlerSpy implements HttpHandler {
	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	public HttpHandlerSpy() {
		MCR.useMRV(MRV);
		MRV.setDefaultReturnValuesSupplier("getResponseText", String::new);
		MRV.setDefaultReturnValuesSupplier("getResponseCode", (Supplier<Integer>) () -> 200);
		MRV.setDefaultReturnValuesSupplier("getErrorText", String::new);
		MRV.setDefaultReturnValuesSupplier("getHeaderField", String::new);
		MRV.setDefaultReturnValuesSupplier("getResponseBinary", InputStreamSpy::new);
	}

	@Override
	public void setRequestMethod(String requestMethod) {
		MCR.addCall("requestMethod", requestMethod);
	}

	@Override
	public String getResponseText() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public int getResponseCode() {
		return (int) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public void setOutput(String outputString) {
		MCR.addCall("outputString", outputString);
	}

	@Override
	public void setRequestProperty(String key, String value) {
		MCR.addCall("key", key, "value", value);
	}

	@Override
	public String getErrorText() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public void setStreamOutput(InputStream stream) {
		MCR.addCall("stream", stream);
	}

	@Override
	public String getHeaderField(String name) {
		return (String) MCR.addCallAndReturnFromMRV("name", name);
	}

	@Override
	public void setBasicAuthorization(String username, String password) {
		MCR.addCall("username", username, "password", password);

	}

	@Override
	public InputStream getResponseBinary() {
		return (InputStream) MCR.addCallAndReturnFromMRV();
	}

}
