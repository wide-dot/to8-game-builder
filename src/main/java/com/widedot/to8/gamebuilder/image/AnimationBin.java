package com.widedot.to8.gamebuilder.image;

import com.widedot.to8.gamebuilder.builder.FileNames;
import com.widedot.to8.gamebuilder.builder.Object;
import com.widedot.to8.gamebuilder.storage.RAMLoaderIndex;
import com.widedot.to8.gamebuilder.util.knapsack.ItemBin;

public class AnimationBin extends ItemBin{

	public String name = "";
	public String fileName;

	public AnimationBin(String objName) {
		this.fileName = objName + FileNames.ANIMATION;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getFullName() {
		return "AnimationBin "+this.name;
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RAMLoaderIndex getRAMLoaderIndex() {
		// TODO Auto-generated method stub
		return null;
	}

	
}