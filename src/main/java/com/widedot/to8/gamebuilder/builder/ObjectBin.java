package com.widedot.to8.gamebuilder.builder;

import com.widedot.to8.gamebuilder.builder.Object;
import com.widedot.to8.gamebuilder.storage.RAMLoaderIndex;
import com.widedot.to8.gamebuilder.util.knapsack.ItemBin;

public class ObjectBin extends ItemBin{

	public String name = "";
	public Object parent;
	
	public ObjectBin() {
	}
	
	public ObjectBin(Object obj) {
		this.parent = obj;
	}	
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getFullName() {
		return "ObjectBin "+this.name;
	}

	public Object getObject() {
		return parent;
	}

	public RAMLoaderIndex getRAMLoaderIndex() {
		return null;
	}
			
}