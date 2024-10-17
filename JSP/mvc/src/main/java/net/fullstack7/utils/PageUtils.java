package net.fullstack7.utils;

import java.util.List;

import net.fullstack7.bbs.BbsDTO;

public class PageUtils {
	public static int totalBbsCount(List<BbsDTO> bbsList) {
		return bbsList.size();
	}

}
