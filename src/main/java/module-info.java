/**
 * The testspies module provides common spies used when testing Cora projects.
 */
module se.uu.ub.cora.testspies {

	requires org.testng;
	/**
	 * logger, data etc. are not transitive, as it is used for tests and all usages may not need
	 * both, leaving then non transitive means we do not need to include the one we are not using
	 */
	requires se.uu.ub.cora.logger;
	requires se.uu.ub.cora.data;
	requires se.uu.ub.cora.spider;
	requires se.uu.ub.cora.httphandler;
	requires transitive se.uu.ub.cora.testutils;

	exports se.uu.ub.cora.testspies.logger;
	exports se.uu.ub.cora.testspies.data;
	exports se.uu.ub.cora.testspies.spider;
	exports se.uu.ub.cora.testspies.httphandler;
}