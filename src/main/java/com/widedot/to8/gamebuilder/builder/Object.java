package com.widedot.to8.gamebuilder.builder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.widedot.to8.audio.Sound;
import com.widedot.to8.gamebuilder.image.AnimationBin;
import com.widedot.to8.gamebuilder.image.ImageSetBin;
import com.widedot.to8.gamebuilder.image.Sprite;
import com.widedot.to8.gamebuilder.image.SubSpriteBin;
import com.widedot.to8.gamebuilder.image.TileBin;
import com.widedot.to8.gamebuilder.image.Tileset;
import com.widedot.to8.gamebuilder.util.OrderedProperties;

public class Object {

	public String name;
	public String fileName;	
	public String codeFileName;
	public boolean codeInRAM = false;
	public boolean isCommonCode = false;
	
	public HashMap<GameMode, ObjectCode> gmCode = new HashMap<GameMode, ObjectCode>();
	public HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();
	public List<SubSpriteBin> subSpritesBin = new ArrayList<SubSpriteBin>();
	public HashMap<String, Tileset> tilesets = new HashMap<String, Tileset>();
	public List<TileBin> tilesBin = new ArrayList<TileBin>();
	public AnimationBin animation;
	public boolean animationInRAM = false;	
	public ImageSetBin imageSet;
	public boolean imageSetInRAM = false;	
	public List<Sound> sounds = new ArrayList<Sound>();
	
	public HashMap<String, String[]> spritesProperties;
	public HashMap<String, String[]> animationsProperties;	
	public HashMap<String, String[]> animationDataProperties;
	public HashMap<String, String[]> soundsProperties;
	public HashMap<String, String[]> tilesetsProperties;
	
	public Object(GameMode gm, String name, String propertiesFileName) throws Exception {
		this.name = name;
		this.fileName = propertiesFileName;
		this.animation = new AnimationBin(name);
		this.imageSet = new ImageSetBin(name);	
		
		OrderedProperties prop = new OrderedProperties();
		try {
			InputStream input = new FileInputStream(propertiesFileName);
			prop.load(input);
		} catch (Exception e) {
			throw new Exception("Impossible de charger le fichier de configuration: " + propertiesFileName, e);
		}

		String codeTmp = prop.getProperty("code");
		String commonCodeTmp = prop.getProperty("common-code");
		
		if (codeTmp != null && commonCodeTmp != null) {
			throw new Exception("Only one code or common-code property allowed in " + propertiesFileName);
		}
		
		if (codeTmp == null && commonCodeTmp == null) {
			throw new Exception("One code or common-code property mandatory in " + propertiesFileName);
		}

		if (codeTmp == null) {
			codeTmp = commonCodeTmp;
		}
		String[] codeFileNameTmp = codeTmp.split(";");

		if (codeFileNameTmp.length == 0)
			throw new Exception("code or common-code not specified in " + propertiesFileName);
		
		if (commonCodeTmp != null) {
			isCommonCode = true;
		}
		
		// TODO common-code is not yet implemented
		// should result in one code instance, not as many as objects 
		
		// Quand l'objet est cr????, un premier code objet est rattach?? ?? un gameMode
		ObjectCode oc = new ObjectCode(this);
		oc.code = new ObjectBin(this);		
		codeFileName = codeFileNameTmp[0];
		gmCode.put(gm, oc);
		
		if (codeFileNameTmp.length > 1 && codeFileNameTmp[1].equalsIgnoreCase(BuildDisk.RAM))
			codeInRAM = true;				

		spritesProperties = PropertyList.get(prop, "sprite");
		animationsProperties = PropertyList.get(prop, "animation");
		animationDataProperties = PropertyList.get(prop, "animation-data");	
		if (animationDataProperties.size()>1)
			throw new Exception("Only one animation-data allowed in " + propertiesFileName);
		
		soundsProperties = PropertyList.get(prop, "sound");
		tilesetsProperties = PropertyList.get(prop, "tileset");
		
		if (prop.getProperty("spriteIndex") != null && prop.getProperty("spriteIndex").equalsIgnoreCase(BuildDisk.RAM))
			imageSetInRAM = true;
		
		if (prop.getProperty("animationIndex") != null && prop.getProperty("animationIndex").equalsIgnoreCase(BuildDisk.RAM))
			animationInRAM = true;
	}	
	
	public void addGameMode(GameMode gm) throws Exception {
		if (!gmCode.containsKey(gm)) {
			ObjectCode oc = new ObjectCode(this);
			oc.code = new ObjectBin(this);				
			gmCode.put(gm, oc);
		}
	}
}
