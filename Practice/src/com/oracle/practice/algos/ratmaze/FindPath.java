package com.oracle.practice.algos.ratmaze;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

	public static void main(String[] args) {
		Cell a = new Cell("a");
		Cell b = new Cell("b");
		Cell c = new Cell("c");
		Cell d = new Cell("d");
		Cell e = new Cell("e");
		Cell f = new Cell("f");
		Cell g = new Cell("g");
		Cell h = new Cell("h");
		Cell i = new Cell("i");
		a.addNeighbours(d,b);
		b.addNeighbours(a,e,c);
		c.addNeighbours(b);
		d.addNeighbours(a);
		e.addNeighbours(g,f,b);
		f.addNeighbours(e,h);
		g.addNeighbours(e,h);
		h.addNeighbours(f,g,i);
		i.addNeighbours(h);
		i.setEndCell(true);
		
		FindPath fp = new FindPath();
		List<Cell> finalPath = new ArrayList<Cell>();
		fp.findPath(d, finalPath);
		
		finalPath.stream().forEach(System.out::println);
	}

	public boolean findPath(Cell currentCell, List<Cell> currentPath) {
		currentPath.add(currentCell);
		// Base case
		if(currentCell.isEndCell()) {
			return true;
		}
		
		for(Cell neighbour: currentCell.getNeighbours()) {
			if(!currentPath.contains(neighbour)) {
				List<Cell> neighbourPath = new ArrayList<>();
				neighbourPath.addAll(currentPath);
				
				if(findPath(neighbour, neighbourPath)) {
					currentPath.clear();
					currentPath.addAll(neighbourPath);
					return true;
				}
			}
		}
		return false;
	}
}
