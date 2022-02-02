package com.widedot.to8.audio;

import com.widedot.to8.gamebuilder.builder.Object;
import com.widedot.to8.gamebuilder.storage.RAMLoaderIndex;
import com.widedot.to8.gamebuilder.util.knapsack.ItemBin;

public class SoundBin extends ItemBin{

	public String name = "";
	public boolean inRAM = false;
	
	public SoundBin() {	
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getFullName() {
		return "ObjectBin "+this.name;
	}

	public Object getObject() {
		return null;
	}

	public RAMLoaderIndex getRAMLoaderIndex() {
		return null;
	}
	
}