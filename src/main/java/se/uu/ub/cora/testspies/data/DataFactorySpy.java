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

import se.uu.ub.cora.data.DataAtomic;
import se.uu.ub.cora.data.DataAttribute;
import se.uu.ub.cora.data.DataFactory;
import se.uu.ub.cora.data.DataGroup;
import se.uu.ub.cora.data.DataList;
import se.uu.ub.cora.data.DataRecord;
import se.uu.ub.cora.data.DataRecordGroup;
import se.uu.ub.cora.data.DataRecordLink;
import se.uu.ub.cora.data.DataResourceLink;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class DataFactorySpy implements DataFactory {

	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	@Override
	public DataList factorListUsingNameOfDataType(String nameOfDataType) {
		MCR.addCall("nameOfDataType", nameOfDataType);
		return null;
	}

	@Override
	public DataRecord factorRecordUsingDataGroup(DataGroup dataGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataRecordGroup factorRecordGroupUsingNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGroup factorGroupUsingNameInData(String nameInData) {
		MCR.addCall("nameInData", nameInData);
		var returnValue = MRV.getReturnValue(nameInData);
		MCR.addReturned(returnValue);
		return (DataGroup) returnValue;
	}

	@Override
	public DataRecordLink factorRecordLinkUsingNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataRecordLink factorRecordLinkUsingNameInDataAndTypeAndId(String nameInData,
			String recordType, String recordId) {
		MCR.addCall("nameInData", nameInData, "recordType", recordType, "recordId", recordId);
		DataRecordLinkSpy recordLink = new DataRecordLinkSpy();
		MCR.addReturned(recordLink);
		return recordLink;
	}

	@Override
	public DataResourceLink factorResourceLinkUsingNameInData(String nameInData) {
		MCR.addCall("nameInData", nameInData);
		DataResourceLink resourceLink = new DataResourceLinkSpy();
		MCR.addReturned(resourceLink);
		return resourceLink;
	}

	@Override
	public DataAtomic factorAtomicUsingNameInDataAndValue(String nameInData, String value) {
		MCR.addCall("nameInData", nameInData, "value", value);
		DataAtomicSpy returnedValue = new DataAtomicSpy();
		MCR.addReturned(returnedValue);
		return returnedValue;
	}

	@Override
	public DataAtomic factorAtomicUsingNameInDataAndValueAndRepeatId(String nameInData,
			String value, String repeatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataAttribute factorAttributeUsingNameInDataAndValue(String nameInData, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataRecordGroup factorRecordGroupFromDataGroup(DataGroup dataGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
