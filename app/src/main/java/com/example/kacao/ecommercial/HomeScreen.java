package com.example.kacao.ecommercial;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

public class HomeScreen extends FragmentActivity implements ActionBar.TabListener 
{
	
ActionBar bar;
ViewPager viewpager;
FragmentPageAdapter ft;
Fragment mSearchFragment;
Fragment mCartFragment;
Fragment mQuickOrderFragment;

Search search;
MyCart mycart;
QuickOrder quickorder;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		viewpager = new ViewPager(this);
        viewpager.setId(R.id.pager);
        setContentView(viewpager);
        ft = new FragmentPageAdapter(getSupportFragmentManager(),this.getApplicationContext());
        viewpager.setAdapter(ft);
        
		final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        
        bar.addTab(bar.newTab().setText("Search").setTabListener(this));
        bar.addTab(bar.newTab().setText("Cart").setTabListener(this));
        bar.addTab(bar.newTab().setText("Quick Order").setTabListener(this));
        
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				bar.setSelectedNavigationItem(arg0);
				
				Fragment fragment = ((FragmentPageAdapter)viewpager.getAdapter()).getFragment(arg0);
				
				if (arg0 ==1 && fragment != null)
				{
					fragment.onResume();	
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
	}
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
	
	
	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewpager.setCurrentItem(tab.getPosition());
	}


	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	@Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);

	    // Since the pager fragments don't have known tags or IDs, the only way to persist the
	    // reference is to use putFragment/getFragment. Remember, we're not persisting the exact
	    // Fragment instance. This mechanism simply gives us a way to persist access to the
	    // 'current' fragment instance for the given fragment (which changes across orientation
	    // changes).
	    //
	    // The outcome of all this is that the "Refresh" menu button refreshes the stream across
	    // orientation changes.
	    if (mSearchFragment != null) {
	        getSupportFragmentManager().putFragment(outState, "search",
	                mSearchFragment);
	    }
	    
	    if (mCartFragment != null) {
	        getSupportFragmentManager().putFragment(outState, "cart",
	                mCartFragment);
	    }
	    
	    if (mQuickOrderFragment != null) {
	        getSupportFragmentManager().putFragment(outState, "quickorder",
	                mQuickOrderFragment);
	    }
	    
	    
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	    super.onRestoreInstanceState(savedInstanceState);
	    if (mSearchFragment == null) {
	        mSearchFragment = (Search) getSupportFragmentManager()
	                .getFragment(savedInstanceState, "search");
	    }
	    else
	    {
	    	//mSearchFragment.refresh();
	    	Log.d("arindam","search restored");
	    	
	    }
	    
	    if (mCartFragment == null) {
	        mCartFragment = (Search) getSupportFragmentManager()
	                .getFragment(savedInstanceState, "cart");
	    }
	    else
	    {
	    	//mSearchFragment.updateDisplay();
	    	Log.d("arindam","cart restored");
	    	
	    }
	    
	    if (mQuickOrderFragment == null) {
	        mQuickOrderFragment = (Search) getSupportFragmentManager()
	                .getFragment(savedInstanceState, "quickorder");
	    }
	    else
	    {
	    	//mSearchFragment.refresh();
	    	Log.d("arindam","quickorder restored");
	    	
	    }
	    
	    
	} */
}