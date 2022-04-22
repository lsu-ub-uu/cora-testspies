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
package se.uu.ub.cora.testspies.spider;

import se.uu.ub.cora.spider.dependency.SpiderInstanceFactory;
import se.uu.ub.cora.spider.record.Downloader;
import se.uu.ub.cora.spider.record.IncomingLinksReader;
import se.uu.ub.cora.spider.record.RecordCreator;
import se.uu.ub.cora.spider.record.RecordDeleter;
import se.uu.ub.cora.spider.record.RecordListIndexer;
import se.uu.ub.cora.spider.record.RecordListReader;
import se.uu.ub.cora.spider.record.RecordReader;
import se.uu.ub.cora.spider.record.RecordSearcher;
import se.uu.ub.cora.spider.record.RecordUpdater;
import se.uu.ub.cora.spider.record.RecordValidator;
import se.uu.ub.cora.spider.record.Uploader;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;
import se.uu.ub.cora.testutils.mrv.MethodReturnValues;

public class SpiderInstanceFactorySpy implements SpiderInstanceFactory {
	public MethodCallRecorder MCR = new MethodCallRecorder();
	public MethodReturnValues MRV = new MethodReturnValues();

	public SpiderInstanceFactorySpy() {
		MCR.useMRV(MRV);
		MRV.setDefaultReturnValuesSupplier("getDependencyProviderClassName", String::new);
		MRV.setDefaultReturnValuesSupplier("factorRecordCreator", RecordCreatorSpy::new);
	}

	@Override
	public String getDependencyProviderClassName() {
		return (String) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public RecordReader factorRecordReader() {
		return null;
	}

	@Override
	public IncomingLinksReader factorIncomingLinksReader() {
		return null;
	}

	@Override
	public RecordListReader factorRecordListReader() {
		return null;
	}

	@Override
	public RecordCreator factorRecordCreator() {
		return (RecordCreator) MCR.addCallAndReturnFromMRV();
	}

	@Override
	public RecordUpdater factorRecordUpdater() {
		return null;
	}

	@Override
	public RecordDeleter factorRecordDeleter() {
		return null;
	}

	@Override
	public Uploader factorUploader() {
		return null;
	}

	@Override
	public Downloader factorDownloader() {
		return null;
	}

	@Override
	public RecordSearcher factorRecordSearcher() {
		return null;
	}

	@Override
	public RecordValidator factorRecordValidator() {
		return null;
	}

	@Override
	public RecordListIndexer factorRecordListIndexer() {
		return null;
	}
}