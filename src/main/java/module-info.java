/**
 * The testspies module provides common spies used when testing Cora projects.
 */
module se.uu.ub.cora.testspies {

	requires org.testng;
	requires se.uu.ub.cora.data;
	requires se.uu.ub.cora.spider;
	requires se.uu.ub.cora.httphandler;
	requires transitive se.uu.ub.cora.testutils;

	exports se.uu.ub.cora.testspies.data;
	exports se.uu.ub.cora.testspies.spider;
	exports se.uu.ub.cora.testspies.httphandler;
	exports se.uu.ub.cora.testspies.storage;
}