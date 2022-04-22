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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import se.uu.ub.cora.data.Action;
import se.uu.ub.cora.data.DataGroup;
import se.uu.ub.cora.data.DataRecord;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

@SuppressWarnings("exports")
public class DataRecordSpy implements DataRecord {
	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	public DataRecordSpy() {
		MCR.useMRV(MRV);
		MRV.setDefaultReturnValuesSupplier("getType", String::new);
		MRV.setDefaultReturnValuesSupplier("getId", String::new);
		MRV.setDefaultReturnValuesSupplier("getSearchId", String::new);
		MRV.setDefaultReturnValuesSupplier("getDataGroup", DataGroupSpy::new);
	}

	@Override
	public String getType() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public String getId() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public void setDataGroup(DataGroup dataGroup) {
		MCR.addCall("dataGroup", dataGroup);

	}

	@Override
	public DataGroup getDataGroup() {
		return (DataGroup) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasActions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Action> getActions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReadPermission(String readPermission) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addReadPermissions(Collection<String> readPermissions) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getReadPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasReadPermissions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addWritePermission(String writePermission) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWritePermissions(Collection<String> writePermissions) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getWritePermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasWritePermissions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSearchId() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

}
