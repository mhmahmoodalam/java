package com.ex.suduko.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ex.suduko.data.TestDataGenerator;

public class SimpleSudukoRuleTest {
	
	
	private SimpleSudukoRule simpleSudkoRule;
	
	@Before
	public void setup() {
		simpleSudkoRule= new SimpleSudukoRule();
	}
	
	@Test	
	public void validRowConstraintTest() {
		assertTrue(simpleSudkoRule.rowConstraint(TestDataGenerator.hardestProblemBoard, 4));
	}
	
	@Test	
	public void inValidRowConstraintTest() {
		assertFalse(simpleSudkoRule.rowConstraint(TestDataGenerator.invalidSudukoBoard, 4));
	}
	
	

	@After
	public void cleanup() {
		simpleSudkoRule=null;
	}
}
