package procon.uet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class FifthBrain extends ThirdBrain {

	public int bestPlace(TargetArea area, SlatePiece pieces[], int i, ArrayList<Integer> index,
			ArrayList<SlatePiece> selectedPiece) {
		if (i < index.size()) {
			int best = 1024;
			ArrayList<SlatePiece> goodPieces = mostAdjacentPieces(area, pieces[index.get(i)]);

			if (goodPieces.size() == 0) {
				selectedPiece.add(null);
				return bestPlace(area, pieces, i + 1, index, selectedPiece);
			}

			for (int j = 0; j < goodPieces.size(); j++) {
				TargetArea otherArea = area.clone();
				ArrayList<SlatePiece> otherSelectedPieces = (ArrayList<SlatePiece>) selectedPiece.clone();
				otherArea.place(goodPieces.get(j), goodPieces.get(j).getLocation().x,
						goodPieces.get(j).getLocation().y);

				int current = bestPlace(otherArea, pieces, i + 1, index, otherSelectedPieces);
				if (best < current) {
					best = current;
					area.copy(otherArea);
					selectedPiece = (ArrayList<SlatePiece>) otherSelectedPieces.clone();
				}
			}

			return best;
		} else
			return area.countEmptyCells();
	}

	public class IndexSlatePieceSelected {
		ArrayList<Integer> intArr;

		public IndexSlatePieceSelected() {
			intArr = new ArrayList<Integer>();
		}
		public void add(int index) {
			intArr.add(index);
		}
		public ArrayList<Integer> getIntArr() {
			return intArr;
		}
	}

	protected ArrayList<FifthBrain.IndexSlatePieceSelected> getIndexSlatePieceSelectedArr(TargetArea noPieceArea, SlatePiece SlatePieceArr[]) {
		int totalEmptyBlock = noPieceArea.countEmptyCells(); 
		int mark = 0;
		for (int i = 0; i < SlatePieceArr.length; i++) {
			if (mark)
		}
		return null;
	}
}
