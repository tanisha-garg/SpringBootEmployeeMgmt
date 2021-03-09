package com.cg.empmgt.dao;
import java.util.*;

import org.springframework.stereotype.Component;
import com.cg.empmgt.entities.*;

@Component
public class StoreHolder {
	
	public StoreHolder() {
		
	}
		
	private Map<Integer, Employee>store = new HashMap<>();
	
	public Map<Integer, Employee> getStore() {
        return store;
    }
	
	
}
