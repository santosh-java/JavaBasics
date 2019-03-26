package com.oracle.practice.algos.ratmaze;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private String id;
	private boolean isEndCell = false;
	private List<Cell> neighbours = new ArrayList<>();

	public Cell(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public boolean isEndCell() {
		return isEndCell;
	}

	public void setEndCell(boolean isEndCell) {
		this.isEndCell = isEndCell;
	}

	public List<Cell> getNeighbours() {
		return neighbours;
	}

	public void addNeighbours(Cell... cells) {
		for (Cell cell : cells) {
			this.neighbours.add(cell);
		}
	}

	public String toString() {
		return id;
	}
}
