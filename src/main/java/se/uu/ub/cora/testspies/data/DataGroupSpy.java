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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import se.uu.ub.cora.data.DataAtomic;
import se.uu.ub.cora.data.DataAttribute;
import se.uu.ub.cora.data.DataChild;
import se.uu.ub.cora.data.DataGroup;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

@SuppressWarnings("exports")
public class DataGroupSpy implements DataGroup {
	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	public DataGroupSpy() {
		MCR.useMRV(MRV);
		MRV.setDefaultReturnValuesSupplier("getRepeatId", String::new);
		MRV.setDefaultReturnValuesSupplier("getNameInData", String::new);
		MRV.setDefaultReturnValuesSupplier("hasAttributes", (Supplier<Boolean>) () -> false);
		MRV.setDefaultReturnValuesSupplier("getAttribute", DataAttributeSpy::new);
		MRV.setDefaultReturnValuesSupplier("getAttributes", ArrayList<DataAttribute>::new);
		MRV.setDefaultReturnValuesSupplier("hasChildren", (Supplier<Boolean>) () -> true);
		MRV.setDefaultReturnValuesSupplier("containsChildWithNameInData",
				(Supplier<Boolean>) () -> false);
	}

	@Override
	public void setRepeatId(String repeatId) {
		MCR.addCall("repeatId", repeatId);
	}

	@Override
	public String getRepeatId() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public void addAttributeByIdWithValue(String nameInData, String value) {
		MCR.addCall("nameInData", nameInData, "value", value);
	}

	@Override
	public boolean hasAttributes() {
		return (boolean) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public DataAttribute getAttribute(String nameInData) {
		return (DataAttribute) MCR.addCallAndReturnFromMRV("nameInData", nameInData);
	}

	@Override
	public Collection<DataAttribute> getAttributes() {
		return (Collection<DataAttribute>) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public String getNameInData() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public boolean hasChildren() {
		return (boolean) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public boolean containsChildWithNameInData(String nameInData) {
		return (boolean) MCR.addCallAndReturnFromMRV("nameInData", nameInData);
	}

	@Override
	public void addChild(DataChild dataChild) {
		MCR.addCall("dataChild", dataChild);
	}

	@Override
	public void addChildren(Collection<DataChild> dataChildren) {
		MCR.addCall("dataChildren", dataChildren);
	}

	@Override
	public List<DataChild> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataChild> getAllChildrenWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataChild> getAllChildrenWithNameInDataAndAttributes(String nameInData,
			DataAttribute... childAttributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataChild getFirstChildWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirstAtomicValueWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataAtomic> getAllDataAtomicsWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGroup getFirstGroupWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataGroup> getAllGroupsWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataGroup> getAllGroupsWithNameInDataAndAttributes(String nameInData,
			DataAttribute... childAttributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeFirstChildWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllChildrenWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllChildrenWithNameInDataAndAttributes(String nameInData,
			DataAttribute... childAttributes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataAtomic getFirstDataAtomicWithNameInData(String nameInData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataAtomic> getAllDataAtomicsWithNameInDataAndAttributes(
			String childNameInData, DataAttribute... childAttributes) {
		// TODO Auto-generated method stub
		return null;
	}

}
