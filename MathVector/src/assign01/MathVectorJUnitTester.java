package assign01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This tester class assesses the correctness of the MathVector class.
 * 
 * IMPORTANT NOTE: The tests provided to get you started rely heavily on a 
 *                 correctly implemented equals method.  Be careful of false
 *                 positives (i.e., tests that pass because your equals method
 *                 incorrectly returns true). 
 * 
 * @author Erin Parker & Morgan Mischo
 * @version January 9, 2019
 */
class MathVectorJUnitTester {
	
	private MathVector rowVec, rowVecTranspose, unitVec, sumVec, colVec, medRowVec, largeRowVec, medColumn, largeColumn, newMedRowVec, newLargeRowVec, 
	newColVec, newMedColumn, newLargeColumn, sumMedRowVec, sumLargeRowVec, sumColumn, sumMedColumn, sumLargeColumn; 

	@BeforeEach
	void setUp() throws Exception {
		// Creates a row vector with three elements: 3.0, 1.0, 2.0
		rowVec = new MathVector(new double[][]{{3, 1, 2}});
		
		//Creates a medium sized row vector with ten elements: 3.0, 1.0, 2.0, 4.0, 6.0, 7.0, 8.0, 9.0, 5.0, 10.0
		medRowVec = new MathVector(new double[][] {{3, 1, 2, 4, 6, 7, 8, 9, 5, 10}}); 
		
		//Creates a large row vector with fifty elements
		largeRowVec = new MathVector(new double[][] {{3, 1, 2, 4, 6, 7, 8, 9, 5, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}});
		
		
		// Creates a column vector with three elements: 3.0, 1.0, 2.0
		rowVecTranspose = new MathVector(new double[][]{{3}, {1}, {2}});
		
		//Creates a column vector with ten elements: 3.0, 1.0, 2.0, 4.0, 6.0, 7.0, 8.0, 9.0, 5.0, 10.0
		medColumn = new MathVector(new double[][]{{3}, {1}, {2}, {4}, {6}, {7}, {8}, {9}, {5}, {10}});
		
		//Creates a column vector with fifty elements
		largeColumn = new MathVector(new double[][]{{3}, {1}, {2}, {4}, {6}, {7}, {8}, {9}, {5}, {10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {20}, {21}, {22}, {23}, {24}, {25}, {26}, {27}, {28}, {29}, {30}, {31}, {32}, {33}, {34}, {35}, {36}, {37}, {38}, {39}, {40}, {41}, {42}, {43}, {44}, {45}, {46}, {47}, {48}, {49}, {50}});
		
		
		
		// Creates a row vector with three elements: 1.0, 1.0, 1.0
		unitVec = new MathVector(new double[][]{{1, 1, 1}});
		
		// Creates a medium row vector with ten different elements
		newMedRowVec = new MathVector(new double[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}); 
		
		// Creates a large row vector with fifty different elements
		newLargeRowVec = new MathVector(new double[][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}});
		
		
		
		//Creates a column vector with three different elements 
		newColVec = new MathVector(new double[][]{{1}, {1}, {1}});
		
		//Creates a column vector with ten different elements
		newMedColumn = new MathVector(new double[][]{{1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}});
		
		//Creates a column vector with fifty different elements 
		newLargeColumn = new MathVector(new double[][]{{1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}});
		
		
		
		//Creates the sum of medRowVec and newMedRowVec
		sumMedRowVec = new MathVector(new double[][] {{4, 2, 3, 5, 7, 8, 9, 10, 6, 11}}); 
		
		//Creates the sum of largeRowVec and newLargeRowVec
		sumLargeRowVec = new MathVector(new double[][] {{4, 2, 3, 5, 7, 8, 9, 10, 6, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51}});
		
		
		//Creates the sum of rowVecTranspose and newColVec
		sumColumn = new MathVector(new double[][]{{4}, {2}, {3}});
		
		//Creates the sum of medColVec and newMedColVec
		sumMedColumn = new MathVector(new double[][]{{4}, {2}, {3}, {5}, {7}, {8}, {9}, {10}, {6}, {11}});
		
		//Creates the sum of largeColVec and newLargeColVec
		sumLargeColumn = new MathVector(new double[][] {{4}, {2}, {3}, {5}, {7}, {8}, {9}, {10}, {6}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {20}, {21}, {22}, {23}, {24}, {25}, {26}, {27}, {28}, {29}, {30}, {31}, {32}, {33}, {34}, {35}, {36}, {37}, {38}, {39}, {40}, {41}, {42}, {43}, {44}, {45}, {46}, {47}, {48}, {49}, {50}, {51}});
		
		
		// Creates a row vector with three elements: 4.0, 2.0, 3.0
		sumVec = new MathVector(new double[][]{{4, 2, 3}});
		
		// Creates a column vector with five elements: -11.0, 2.5, 36.0, -3.14, 7.1
		colVec = new MathVector(new double[][]{{-11}, {2.5}, {36}, {-3.14}, {7.1}});		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	//Row vector equalities
	
	@Test
	public void smallRowVectorEquality() {
		assertTrue(rowVec.equals(new MathVector(new double[][]{{3, 1, 2}})));
	}
	
	@Test
	public void mediumRowVectorEquality() {
		assertTrue(medRowVec.equals(new MathVector(new double[][]{{3, 1, 2, 4, 6, 7, 8, 9, 5, 10}})));
	}
	
	@Test
	public void largeRowVectorEquality() {
		assertTrue(medRowVec.equals(new MathVector(new double[][] {{3, 1, 2, 4, 6, 7, 8, 9, 5, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}})));
	}
	
	
	//Column vector equalities
	
	@Test
	public void smallColumnVectorEquality() {
		assertTrue(rowVecTranspose.equals(new MathVector(new double[][]{{3}, {1}, {2}})));
	}
	
	@Test
	public void mediumColumnVectorEquality() {
		assertTrue(medColumn.equals(new MathVector(new double[][]{{3}, {1}, {2}, {4}, {6}, {7}, {8}, {9}, {5}, {10}})));
	}
	
	@Test
	public void largeColumnVectorEquality() {
		assertTrue(largeColumn.equals(new MathVector(new double[][]{{3}, {1}, {2}, {4}, {6}, {7}, {8}, {9}, {5}, {10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {20}, {21}, {22}, {23}, {24}, {25}, {26}, {27}, {28}, {29}, {30}, {31}, {32}, {33}, {34}, {35}, {36}, {37}, {38}, {39}, {40}, {41}, {42}, {43}, {44}, {45}, {46}, {47}, {48}, {49}, {50}}))); 
	}
	
	
	//Row Vector inequalities
	
	@Test
	public void smallRowVectorInequality() {
		assertFalse(rowVec.equals(unitVec));
	}
	
	@Test
	public void medRowVectorInequality() {
		assertFalse(medRowVec.equals(newMedRowVec));
	}
	
	@Test
	public void largeRowVectorInequality() {
		assertFalse(largeRowVec.equals(newLargeRowVec));
	}
	
	
	
	//Column Vector inequalities
	
	@Test
	public void smallColVectorInequality() {
		assertFalse(rowVecTranspose.equals(newColVec));
	}
	
	@Test
	public void medColVectorInequality() {
		assertFalse(medColumn.equals(newMedColumn));
	}
	
	@Test
	public void largeColVectorInequality() {
		assertFalse(largeColumn.equals(newLargeColumn));
	}
	
	
	
	//Creating vectors from bad arrays

	@Test
	public void createVectorFromBadArray() {
	  double arr[][] = {{1, 2}, {3, 4}};
	  assertThrows(IllegalArgumentException.class, () -> { new MathVector(arr); });
	  // NOTE: The code above is an example of a lambda expression. See Lab 1 for more info.
	}
	
	
	
	
	
	//Transposing row vectors
	
	@Test
	public void transposeSmallRowVector() {
		MathVector transposeResult = rowVec.transpose();
		assertTrue(transposeResult.equals(rowVecTranspose));
	}
	
	@Test
	public void transposeMediumRowVector() {
		MathVector transposeResult = medRowVec.transpose();
		assertTrue(transposeResult.equals(medColumn));
	}
	
	@Test
	public void transposeLargeRowVector() {
		MathVector transposeResult = largeRowVec.transpose();
		assertTrue(transposeResult.equals(largeColumn));
	}
	
	
	
	
	//Transposing column vectors 
	
	@Test
	public void transposeSmallColVector() {
		MathVector transposeResult = rowVecTranspose.transpose();
		assertTrue(transposeResult.equals(rowVec));
	}
	
	@Test
	public void transposeMedColVector() {
		MathVector transposeResult = medColumn.transpose();
		assertTrue(transposeResult.equals(medRowVec));
	}
	
	@Test
	public void transposeLargeColVector() {
		MathVector transposeResult = largeColumn.transpose();
		assertTrue(transposeResult.equals(largeRowVec));
	}
	
	
	
	
	//Trying to add Row and Col Vectors
	
	@Test
	public void addRowAndColVectors() {
	  assertThrows(IllegalArgumentException.class, () -> { rowVec.add(colVec); });
	  // NOTE: The code above is an example of a lambda expression. See Lab 1 for more info.
	}

	
	
	
	//Adding row vectors
	
	@Test
	public void addSmallRowVectors() {
		MathVector addResult = rowVec.add(unitVec);
		assertTrue(addResult.equals(sumVec));		
	}

	@Test
	public void addMedRowVectors() {
		MathVector addResult = medRowVec.add(newMedRowVec);
		assertTrue(addResult.equals(sumMedRowVec));		
	}
	
	@Test
	public void addLargeRowVectors() {
		MathVector addResult = largeRowVec.add(newLargeRowVec);
		assertTrue(addResult.equals(sumLargeRowVec));		
	}
	
	
	
	
	//Adding column vectors
	
	@Test
	public void addSmallColumns() {
		MathVector addResult = rowVecTranspose.add(newColVec);
		assertTrue(addResult.equals(sumColumn));		
	}
	
	@Test
	public void addMedColumns() {
		MathVector addResult = medColumn.add(newMedColumn);
		assertTrue(addResult.equals(sumMedColumn));		
	}
	
	@Test
	public void addLargeColumns() {
		MathVector addResult = largeColumn.add(newLargeColumn);
		assertTrue(addResult.equals(sumLargeColumn));		
	}
	
	
	
	//Dot product for row vectors
	
	@Test
	public void dotProductSmallRowVectors() {
		double dotProdResult = rowVec.dotProduct(unitVec);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0);		
	}
	
	@Test
	public void dotProductMedRowVectors() {
		double dotProdResult = medRowVec.dotProduct(newMedRowVec);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0 + 4.0 * 1.0 + 6.0 * 1.0 + 7.0 * 1.0 + 8.0 * 1.0 + 9.0 * 1.0 + 5.0 * 1.0 + 10.0 * 1.0);		
	}
	
	@Test
	public void dotProductLargeRowVectors() {
		double dotProdResult = largeRowVec.dotProduct(newLargeRowVec);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0 + 4.0 * 1.0 + 6.0 * 1.0 + 7.0 * 1.0 + 8.0 * 1.0 + 9.0 * 1.0 + 5.0 * 1.0 + 10.0 * 1.0 + 11.0 * 1.0 + 12.0 * 1.0 + 13.0 * 1.0 + 14.0 * 1.0 + 15.0 * 1.0 + 16.0 * 1.0 + 17.0 * 1.0 + 18.0 * 1.0 + 19.0 * 1.0 + 20.0 * 1.0 + 21.0 * 1.0 + 22.0 * 1.0 + 23.0 * 1.0 + 24.0 * 1.0 + 25.0 * 1.0 + 26.0 * 1.0 + 27.0 * 1.0 + 28.0 * 1.0 + 29.0 * 1.0 + 30.0 * 1.0 + 31.0 * 1.0 + 32.0 * 1.0 + 33.0 * 1.0 + 34.0 * 1.0 + 35.0 * 1.0 + 36.0 * 1.0 + 37.0 * 1.0 + 38.0 * 1.0 + 39.0 * 1.0 + 40.0 * 1.0 + 41.0 * 1.0 + 42.0 * 1.0 + 43.0 * 1.0 + 44.0 * 1.0 + 45.0 * 1.0 + 46.0 * 1.0 + 47.0 * 1.0 + 48.0 * 1.0 + 49.0 * 1.0 + 50.0 * 1.0);		
	}
	
	
	
	
	//Dot product for columns
	
	@Test
	public void dotProductSmallColumns() {
		double dotProdResult = rowVecTranspose.dotProduct(newColVec);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0);		
	}
	
	@Test
	public void dotProductMedColumns() {
		double dotProdResult = medColumn.dotProduct(newMedColumn);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0 + 4.0 * 1.0 + 6.0 * 1.0 + 7.0 * 1.0 + 8.0 * 1.0 + 9.0 * 1.0 + 5.0 * 1.0 + 10.0 * 1.0);	
	}
	
	@Test
	public void dotProductLargeColumns() {
		double dotProdResult = largeColumn.dotProduct(newLargeColumn);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0 + 4.0 * 1.0 + 6.0 * 1.0 + 7.0 * 1.0 + 8.0 * 1.0 + 9.0 * 1.0 + 5.0 * 1.0 + 10.0 * 1.0 + 11.0 * 1.0 + 12.0 * 1.0 + 13.0 * 1.0 + 14.0 * 1.0 + 15.0 * 1.0 + 16.0 * 1.0 + 17.0 * 1.0 + 18.0 * 1.0 + 19.0 * 1.0 + 20.0 * 1.0 + 21.0 * 1.0 + 22.0 * 1.0 + 23.0 * 1.0 + 24.0 * 1.0 + 25.0 * 1.0 + 26.0 * 1.0 + 27.0 * 1.0 + 28.0 * 1.0 + 29.0 * 1.0 + 30.0 * 1.0 + 31.0 * 1.0 + 32.0 * 1.0 + 33.0 * 1.0 + 34.0 * 1.0 + 35.0 * 1.0 + 36.0 * 1.0 + 37.0 * 1.0 + 38.0 * 1.0 + 39.0 * 1.0 + 40.0 * 1.0 + 41.0 * 1.0 + 42.0 * 1.0 + 43.0 * 1.0 + 44.0 * 1.0 + 45.0 * 1.0 + 46.0 * 1.0 + 47.0 * 1.0 + 48.0 * 1.0 + 49.0 * 1.0 + 50.0 * 1.0);		
	}
	
	
	
	
	
	//Row vector magnitudes
	
	@Test
	public void smallRowVectorMagnitude() {
		double vecMagnitude = rowVec.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0));		
	}
	
	@Test
	public void medRowVectorMagnitude() {
		double vecMagnitude = medRowVec.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0));		
	}
	
	@Test
	public void largeRowVectorMagnitude() {
		double vecMagnitude = largeRowVec.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0 + 11.0 * 11.0 + 12.0 * 12.0 + 13.0 * 13.0 + 14.0 * 14.0 + 15.0 * 15.0 + 16.0 * 16.0 + 17.0 * 17.0 + 18.0 * 18.0 + 19.0 * 19.0 + 20.0 * 20.0 + 21.0 * 21.0 + 22.0 * 22.0 + 23.0 * 23.0 + 24.0 * 24.0 + 25.0 * 25.0 + 26.0 * 26.0 + 27.0 * 27.0 + 28.0 * 28.0 + 29.0 * 29.0 + 30.0 * 30.0 + 31.0 * 31.0 + 32.0 * 32.0 + 33.0 * 33.0 + 34.0 * 34.0 + 35.0 * 35.0 + 36.0 * 36.0 + 37.0 * 37.0 + 38.0 * 38.0 + 39.0 * 39.0 + 40.0 * 40.0 + 41.0 * 41.0 + 42.0 * 42.0 + 43.0 * 43.0 + 44.0 * 44.0 + 45.0 * 45.0 + 46.0 * 46.0 + 47.0 * 47.0 + 48.0 * 48.0 + 49.0 * 49.0 + 50.0 * 50.0));		
	}
	
	
	
	
	//Column vector magnitudes
	
	@Test
	public void smallColumnMagnitude() {
		double vecMagnitude = rowVecTranspose.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0));		
	}
	
	@Test
	public void medColumnMagnitude() {
		double vecMagnitude = medColumn.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0));		
	}
	
	@Test
	public void largeColumnMagnitude() {
		double vecMagnitude = largeColumn.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0 + 11.0 * 11.0 + 12.0 * 12.0 + 13.0 * 13.0 + 14.0 * 14.0 + 15.0 * 15.0 + 16.0 * 16.0 + 17.0 * 17.0 + 18.0 * 18.0 + 19.0 * 19.0 + 20.0 * 20.0 + 21.0 * 21.0 + 22.0 * 22.0 + 23.0 * 23.0 + 24.0 * 24.0 + 25.0 * 25.0 + 26.0 * 26.0 + 27.0 * 27.0 + 28.0 * 28.0 + 29.0 * 29.0 + 30.0 * 30.0 + 31.0 * 31.0 + 32.0 * 32.0 + 33.0 * 33.0 + 34.0 * 34.0 + 35.0 * 35.0 + 36.0 * 36.0 + 37.0 * 37.0 + 38.0 * 38.0 + 39.0 * 39.0 + 40.0 * 40.0 + 41.0 * 41.0 + 42.0 * 42.0 + 43.0 * 43.0 + 44.0 * 44.0 + 45.0 * 45.0 + 46.0 * 46.0 + 47.0 * 47.0 + 48.0 * 48.0 + 49.0 * 49.0 + 50.0 * 50.0));		
	}
	
	
	
	
	
	//Row vectors normalized 
	
	@Test
	public void smallRowVectorNormalize() {
		MathVector normalVec = rowVec.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0);
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude, 1.0 / magnitude, 2.0 / magnitude}})));		
	}
	
	@Test
	public void medRowVectorNormalize() {
		MathVector normalVec = medRowVec.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0);
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude, 1.0 / magnitude, 2.0 / magnitude, 4.0 / magnitude, 6.0 / magnitude, 7.0  / magnitude, 8.0  / magnitude, 9.0  / magnitude, 5.0  / magnitude, 10.0  / magnitude,}})));		
	}
	
	@Test
	public void largeRowVectorNormalize() {
		MathVector normalVec = largeRowVec.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0 + 11.0 * 11.0 + 12.0 * 12.0 + 13.0 * 13.0 + 14.0 * 14.0 + 15.0 * 15.0 + 16.0 * 16.0 + 17.0 * 17.0 + 18.0 * 18.0 + 19.0 * 19.0 + 20.0 * 20.0 + 21.0 * 21.0 + 22.0 * 22.0 + 23.0 * 23.0 + 24.0 * 24.0 + 25.0 * 25.0 + 26.0 * 26.0 + 27.0 * 27.0 + 28.0 * 28.0 + 29.0 * 29.0 + 30.0 * 30.0 + 31.0 * 31.0 + 32.0 * 32.0 + 33.0 * 33.0 + 34.0 * 34.0 + 35.0 * 35.0 + 36.0 * 36.0 + 37.0 * 37.0 + 38.0 * 38.0 + 39.0 * 39.0 + 40.0 * 40.0 + 41.0 * 41.0 + 42.0 * 42.0 + 43.0 * 43.0 + 44.0 * 44.0 + 45.0 * 45.0 + 46.0 * 46.0 + 47.0 * 47.0 + 48.0 * 48.0 + 49.0 * 49.0 + 50.0 * 50.0);		
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude, 1.0 / magnitude, 2.0 / magnitude, 4.0 / magnitude, 6.0 / magnitude, 7.0 / magnitude, 8.0 / magnitude, 9.0 / magnitude, 5.0 / magnitude, 10.0 / magnitude, 11.0 / magnitude, 12.0 / magnitude, 13.0 / magnitude, 14.0 / magnitude, 15.0 / magnitude, 16.0 / magnitude, 17.0 / magnitude, 18.0 / magnitude, 19.0 / magnitude, 20.0 / magnitude, 21.0 / magnitude, 22.0 / magnitude, 23.0 / magnitude, 24.0 / magnitude, 25.0 / magnitude, 26.0 / magnitude, 27.0 / magnitude, 28.0 / magnitude, 29.0 / magnitude, 30.0 / magnitude, 31.0 / magnitude, 32.0 / magnitude, 33.0 / magnitude, 34.0 / magnitude, 35.0 / magnitude, 36.0 / magnitude, 37.0 / magnitude, 38.0 / magnitude, 39.0 / magnitude, 40.0 / magnitude, 41.0 / magnitude, 42.0 / magnitude, 43.0 / magnitude, 44.0 / magnitude, 45.0 / magnitude, 46.0 / magnitude, 47.0 / magnitude, 48.0 / magnitude, 49.0/ magnitude, 50.0 / magnitude}})));		
	}
	
	
	
	
	//Columns normalized
	
	@Test
	public void smallColumnNormalize() {
		MathVector normalVec = rowVecTranspose.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0);
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude}, {1.0 / magnitude}, {2.0 / magnitude}})));		
	}
	
	@Test
	public void medColumnNormalize() {
		MathVector normalVec = medColumn.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0);
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude}, {1.0 / magnitude}, {2.0 / magnitude}, {4.0 / magnitude}, {6.0 / magnitude}, {7.0  / magnitude}, {8.0  / magnitude}, {9.0  / magnitude}, {5.0  / magnitude}, {10.0  / magnitude,}})));		
	}
	
	@Test
	public void largeColumnNormalize() {
		MathVector normalVec = largeColumn.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0 + 4.0 * 4.0 + 6.0 * 6.0 + 7.0 * 7.0 + 8.0 * 8.0 + 9.0 * 9.0 + 5.0 * 5.0 + 10.0 * 10.0 + 11.0 * 11.0 + 12.0 * 12.0 + 13.0 * 13.0 + 14.0 * 14.0 + 15.0 * 15.0 + 16.0 * 16.0 + 17.0 * 17.0 + 18.0 * 18.0 + 19.0 * 19.0 + 20.0 * 20.0 + 21.0 * 21.0 + 22.0 * 22.0 + 23.0 * 23.0 + 24.0 * 24.0 + 25.0 * 25.0 + 26.0 * 26.0 + 27.0 * 27.0 + 28.0 * 28.0 + 29.0 * 29.0 + 30.0 * 30.0 + 31.0 * 31.0 + 32.0 * 32.0 + 33.0 * 33.0 + 34.0 * 34.0 + 35.0 * 35.0 + 36.0 * 36.0 + 37.0 * 37.0 + 38.0 * 38.0 + 39.0 * 39.0 + 40.0 * 40.0 + 41.0 * 41.0 + 42.0 * 42.0 + 43.0 * 43.0 + 44.0 * 44.0 + 45.0 * 45.0 + 46.0 * 46.0 + 47.0 * 47.0 + 48.0 * 48.0 + 49.0 * 49.0 + 50.0 * 50.0);		
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude}, {1.0 / magnitude}, {2.0 / magnitude}, {4.0 / magnitude}, {6.0 / magnitude}, {7.0 / magnitude}, {8.0 / magnitude}, {9.0 / magnitude}, {5.0 / magnitude}, {10.0 / magnitude}, {11.0 / magnitude}, {12.0 / magnitude}, {13.0 / magnitude}, {14.0 / magnitude}, {15.0 / magnitude}, {16.0 / magnitude}, {17.0 / magnitude}, {18.0 / magnitude}, {19.0 / magnitude}, {20.0 / magnitude}, {21.0 / magnitude}, {22.0 / magnitude}, {23.0 / magnitude}, {24.0 / magnitude}, {25.0 / magnitude}, {26.0 / magnitude}, {27.0 / magnitude}, {28.0 / magnitude}, {29.0 / magnitude}, {30.0 / magnitude}, {31.0 / magnitude}, {32.0 / magnitude}, {33.0 / magnitude}, {34.0 / magnitude}, {35.0 / magnitude}, {36.0 / magnitude}, {37.0 / magnitude}, {38.0 / magnitude}, {39.0 / magnitude}, {40.0 / magnitude}, {41.0 / magnitude}, {42.0 / magnitude}, {43.0 / magnitude}, {44.0 / magnitude}, {45.0 / magnitude}, {46.0 / magnitude}, {47.0 / magnitude}, {48.0 / magnitude}, {49.0/ magnitude}, {50.0 / magnitude}})));		
	}
	
	
	
	//Rows to String
	
	@Test
	public void smallRowVectorToString() {
		String resultStr = "3.0 1.0 2.0";
		assertEquals(rowVec.toString(), resultStr);		
	}
	
	@Test
	public void medRowVectorToString() {
		String resultStr = "3.0 1.0 2.0 4.0 6.0 7.0 8.0 9.0 5.0 10.0";
		assertEquals(medRowVec.toString(), resultStr);		
	}
	
	@Test
	public void largeRowVectorToString() {
		String resultStr = "3.0 1.0 2.0 4.0 6.0 7.0 8.0 9.0 5.0 10.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0 18.0 19.0 20.0 21.0 22.0 23.0 24.0 25.0 26.0 27.0 28.0 29.0 30.0 31.0 32.0 33.0 34.0 35.0 36.0 37.0 38.0 39.0 40.0 41.0 42.0 43.0 44.0 45.0 46.0 47.0 48.0 49.0 50.0";
		assertEquals(largeRowVec.toString(), resultStr);		
	}
	
	
	
	
	
	//Columns to String
	
	@Test
	public void smallColVectorToString() {
		String resultStr = "-11.0\n2.5\n36.0\n-3.14\n7.1";
		assertEquals(colVec.toString(), resultStr);		
	}
	@Test
	public void medColumnToString() {
		String resultStr = "3.0\n1.0\n2.0\n4.0\n6.0\n7.0\n8.0\n9.0\n5.0\n10.0";
		assertEquals(medColumn.toString(), resultStr);		
	}
	
	@Test
	public void largeColumnToString() {
		String resultStr = "3.0\n1.0\n2.0\n4.0\n6.0\n7.0\n8.0\n9.0\n5.0\n10.0\n11.0\n12.0\n13.0\n14.0\n15.0\n16.0\n17.0\n18.0\n19.0\n20.0\n21.0\n22.0\n23.0\n24.0\n25.0\n26.0\n27.0\n28.0\n29.0\n30.0\n31.0\n32.0\n33.0\n34.0\n35.0\n36.0\n37.0\n38.0\n39.0\n40.0\n41.0\n42.0\n43.0\n44.0\n45.0\n46.0\n47.0\n48.0\n49.0\n50.0";
		assertEquals(largeColumn.toString(), resultStr);		
	}

}
