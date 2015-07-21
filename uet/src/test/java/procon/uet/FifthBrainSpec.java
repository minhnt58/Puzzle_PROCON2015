package procon.uet;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FifthBrainSpec {
	private static FileManager fileMgr;
	private static TargetArea target11;
	private static SlatePiece[] pieces;
	private static FifthBrain brain;
	
	@Before
	public void setup(){
		fileMgr = new FileManager("test.txt");
		fileMgr.readFile();
		target11 = new TargetArea(fileMgr.getAreaString());
		pieces = fileMgr.getPieceArr();
		brain = new FifthBrain();
		target11.commit();
	}
	
	@Test
	public void testBestPlace(){
		ArrayList<SlatePiece> selectedPiece = new ArrayList<SlatePiece>();
		ArrayList<Integer> index = new ArrayList<Integer>(){{
			add(0);
//			add(1);
//			add(2);
//			add(3);
//			add(4);
//			add(5);
		}};
		
		System.out.println(SlatePiece.blocksOfAllPieces(pieces, index));
		System.out.println(brain.bestPlace(target11, pieces, 0, index, selectedPiece));
		System.out.println();
		System.out.println(selectedPiece);
		target11.print();
	}
}