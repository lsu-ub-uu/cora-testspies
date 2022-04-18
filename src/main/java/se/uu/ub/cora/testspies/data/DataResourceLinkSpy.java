package se.uu.ub.cora.testspies.data;

import java.util.Collection;

import se.uu.ub.cora.data.Action;
import se.uu.ub.cora.data.DataAttribute;
import se.uu.ub.cora.data.DataResourceLink;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class DataResourceLinkSpy implements DataResourceLink {
	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasReadAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRepeatId(String repeatId) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getRepeatId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameInData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttributeByIdWithValue(String nameInData, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasAttributes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataAttribute getAttribute(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataAttribute> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStreamId(String streamId) {
		MCR.addCall("streamId", streamId);
	}

	@Override
	public String getStreamId() {
		MCR.addCall();
		String returnValue = (String) MRV.getReturnValue();
		MCR.addReturned(returnValue);
		return returnValue;
	}

	@Override
	public void setFileName(String fileName) {
		MCR.addCall("fileName", fileName);

	}

	@Override
	public String getFileName() {
		MCR.addCall();
		String returnValue = (String) MRV.getReturnValue();
		MCR.addReturned(returnValue);
		return returnValue;
	}

	@Override
	public void setFileSize(String fileSize) {
		MCR.addCall("fileSize", fileSize);

	}

	@Override
	public String getFileSize() {
		MCR.addCall();
		String returnValue = (String) MRV.getReturnValue();
		MCR.addReturned(returnValue);
		return returnValue;
	}

	@Override
	public void setMimeType(String mimeType) {
		MCR.addCall("mimeType", mimeType);

	}

	@Override
	public String getMimeType() {
		MCR.addCall();
		String returnValue = (String) MRV.getReturnValue();
		MCR.addReturned(returnValue);
		return returnValue;
	}

}
