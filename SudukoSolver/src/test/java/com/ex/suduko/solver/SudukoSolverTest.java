package com.ex.suduko.solver;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ex.suduko.board.SudukoBoard;
import com.ex.suduko.data.TestDataGenerator;
import com.ex.suduko.rules.SimpleSudukoRule;
import com.ex.suduko.rules.SudukoBoardRule;

@RunWith(Parameterized.class)
public class SudukoSolverTest {
	
	private SudukoBoardRule sudukoBoardRule;
	private SudukoBoard sudukoBoard;

	public SudukoSolverTest(SudukoBoard sudukoBoard,SudukoBoardRule sudukoBoardRule) {
		this.sudukoBoard=sudukoBoard;
		this.sudukoBoardRule=sudukoBoardRule;
	}
	
	@Parameters
	public static Collection<Object[]> getSudkoBoardProblem() {
		return Arrays.asList(new Object[][] {{new SudukoBoard(TestDataGenerator.problemBoard, 9, 3), new SimpleSudukoRule()},
			{new SudukoBoard(TestDataGenerator.hardestProblemBoard, 9, 3), new SimpleSudukoRule()}});
	}
	
	@Test
	public void solveSudukoTest() {
		SudukoSolver sudukoSolver= new SudukoSolver();
		sudukoSolver.setSudukoBoard(sudukoBoard);
		sudukoSolver.setSudukoBoardRule(sudukoBoardRule);
		assertTrue(sudukoSolver.solve());
		
	}
	
}
