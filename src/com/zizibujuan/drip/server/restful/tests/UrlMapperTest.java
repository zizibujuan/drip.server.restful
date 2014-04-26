package com.zizibujuan.drip.server.restful.tests;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Before;
import org.junit.Test;

import com.zizibujuan.drip.server.restful.UrlMapper;

public class UrlMapperTest {

	private UrlMapper urlMapper;
	
	@Before
	public void setup(){
		urlMapper = new UrlMapper();
	}
	
	// /courses --> /courses  如果没有变化，则不forward，而是继续执行
	@Test
	public void testMapperBefore(){
		String result = urlMapper.getNewPath("courses", null);
		assertEquals("courses", result);
	}
	
	// /{courseId}/lessons --> /lessons/{courseId}
	@Test
	public void testMapperAfter(){
		IPath path = new Path("/1/lessons");
		String result = urlMapper.getNewPath("", path);
		assertEquals("/lessons/1", result);
	}
}
