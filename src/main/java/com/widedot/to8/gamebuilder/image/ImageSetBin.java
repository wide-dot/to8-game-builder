package com.widedot.to8.gamebuilder.image;

import com.widedot.to8.gamebuilder.builder.FileNames;
import com.widedot.to8.gamebuilder.builder.Object;
import com.widedot.to8.gamebuilder.storage.RAMLoaderIndex;
import com.widedot.to8.gamebuilder.util.knapsack.ItemBin;

public class ImageSetBin extends ItemBin{

	public String name = "";
	public String fileName;	

	public ImageSetBin(String objName) {
		this.fileName = objName + FileNames.IMAGE_SET;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getFullName() {
		return "ImageSetBin "+this.name;
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