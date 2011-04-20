package net.catosplace.pkdroid.test;

import net.catosplace.pkdroid.PKDroid;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TabHost;

public class PKDroidTest extends ActivityInstrumentationTestCase2<PKDroid> {

	private PKDroid mActivity;
	private TabHost mTabHost;
	
	public PKDroidTest() {
		super("net.catosplace.pkdroid", PKDroid.class);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mTabHost = mActivity.getTabHost();
		//mView = (TextView) mActivity.findViewById(net.catosplace.pkdroid.R.id.add_task);
		//resourceString = mActivity.getString(net.catosplace.pkdroid.R.string.add_task_hint);
	}
	
	public void testPreconditions() {
		assertNotNull(mTabHost);
	}
	
	@UiThreadTest
	public void testInitialTabHosts() {
		assertEquals(3, mTabHost.getTabWidget().getChildCount());
		assertEquals(1, mTabHost.getCurrentTab());
		mTabHost.setCurrentTab(0);
		assertEquals("backlog", mTabHost.getCurrentTabTag());
		//assertEquals("backlog", mTabHost.getTag(0));
		//assertEquals("Done", mTabHost.getTag(2));
	}
}
