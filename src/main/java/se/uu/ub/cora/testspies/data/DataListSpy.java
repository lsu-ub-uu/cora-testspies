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

import java.util.List;

import se.uu.ub.cora.data.Data;
import se.uu.ub.cora.data.DataList;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

@SuppressWarnings("exports")
public class DataListSpy implements DataList {
	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	public DataListSpy() {
		MCR.useMRV(MRV);
		// MRV.setDefaultReturnValuesSupplier("hasReadAction", (Supplier<Boolean>) () -> false);
		// MRV.setDefaultReturnValuesSupplier("getRepeatId", String::new);
		// MRV.setDefaultReturnValuesSupplier("getNameInData", String::new);
		// MRV.setDefaultReturnValuesSupplier("hasAttributes", (Supplier<Boolean>) () -> false);
		// MRV.setDefaultReturnValuesSupplier("getAttribute", DataAttributeSpy::new);
		// MRV.setDefaultReturnValuesSupplier("getAttributes", ArrayList<DataAttribute>::new);
		// MRV.setDefaultReturnValuesSupplier("getLinkedRecordId", String::new);
		// MRV.setDefaultReturnValuesSupplier("getLinkedRecordType", String::new);
	}

	@Override
	public String getFromNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTotalNumberOfTypeInStorage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContainDataOfType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Data> getDataList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addData(Data data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFromNo(String position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToNo(String position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTotalNo(String totalNumber) {
		// TODO Auto-generated method stub

	}

}
