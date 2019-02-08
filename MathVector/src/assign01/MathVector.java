package assign01;

/**
 * This class represents a simple row or column vector of numbers.
 * In a row vector, the numbers are written horizontally (i.e., along the columns).
 * In a column vector, the numbers are written vertically (i.e., along the rows).
 * 
 * @author Erin Parker & Morgan Mischo
 * @version January 9, 2019
 */
public class MathVector {

	// 2D array to hold the numbers of the vector, either along the columns or rows
	private double[][] data;      
	// set to true for a row vector and false for a column vector
	private boolean isRowVector;
	// count of elements in the vector
	private int vectorSize;
	
	private String result; 
	
	/**
	 * Creates a new row or column vector.
	 * For a row vector, the input array is expected to have 1 row and a positive number of columns,
	 * and this number of columns represents the vector's length.
	 * For a column vector, the input array is expected to have 1 column and a positive number of rows,
	 * and this number of rows represents the vector's length.
	 * 
	 * @param data - a 2D array to hold the numbers of the vector
	 * @throws IllegalArgumentException if the numbers of rows and columns in the input 2D array is not 
	 *         compatible with a row or column vector
	 */
	public MathVector(double[][] data) {
		if(data.length == 0)
			throw new IllegalArgumentException("Number of rows must be positive.");
		if(data[0].length == 0)
			throw new IllegalArgumentException("Number of columns must be positive.");
		
		if(data.length == 1) {
			// This is a row vector with length = number of columns.
			this.isRowVector = true;
			this.vectorSize = data[0].length;
		}
		else if(data[0].length == 1) {
			// This is a column vector with length = number of rows.
			this.isRowVector = false;
			this.vectorSize = data.length;
		}
		else
			throw new IllegalArgumentException("Either the number of rows or the number of columns must be 1.");
		
		// Create the array and copy data over.
		if(this.isRowVector)
			this.data = new double[1][vectorSize];
		else
			this.data = new double[vectorSize][1];
		for(int i=0; i < this.data.length; i++) { 
			for(int j=0; j < this.data[0].length; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}
	
	/**
	 * Determines whether this vector is "equal to" another vector, where equality is
	 * defined as both vectors being row (or both being column), having the same 
	 * vector length, and containing the same numbers in the same positions.
	 * 
	 * @param other - another vector to compare
	 */
	public boolean equals(Object other) {
		if(!(other instanceof MathVector))
			return false;
		
		MathVector otherVec = (MathVector)other;
		
		if((this.isRowVector && !(otherVec.isRowVector)) || (!(this.isRowVector) && otherVec.isRowVector) )
		{
			throw new IllegalArgumentException("Both entries must be rows or columns"); 
		}
		
		else
		{
			for (int i = 0; i < this.data.length; i++)
			{
				for (int j = 0; j < this.data[0].length; j++)
				{
					if (this.data[i][j] != otherVec.data[i][j])
					{
						return false; 
					}
				}
			}
		}

		return true;
	}
	
	/**
	 * Generates a returns a new vector that is the transposed version of this vector.
	 */
	public MathVector transpose() {
		
		int a = this.data[0].length;   
		int b = this.data.length; 
		double[][] temp = new double[a][b]; 
		
		if (this.isRowVector)
		{
			for (int i = 0; i < this.data[0].length; i++)
			{
			  temp[i][0] = this.data[0][i];  
			}
		}
		
		else if (!this.isRowVector)
		{
			for (int i = 0; i < this.data.length; i++)
			{
				temp[0][i] = this.data[i][0]; 
			}
		}
		MathVector transpose = new MathVector(temp); 
		return transpose; 
	}
	
	/**
	 * Generates and returns a new vector representing the sum of this vector and another vector.
	 * 
	 * @param other - another vector to be added to this vector
	 * @throws IllegalArgumentException if the other vector and this vector are not both row vectors of
	 *         the same length or column vectors of the same length
	 */
	public MathVector add(MathVector other) {
		
		double tempThis; 
		double tempOther; 
		double sum; 
		MathVector mySum = new MathVector(data); 
		
		if (this.isRowVector && !(other.isRowVector) || !(this.isRowVector) && other.isRowVector)
		{
			throw new IllegalArgumentException("Must both be columns or both be rows"); 
		}
		else if (this.data.length != other.data.length || this.data[0].length != other.data[0].length)
		{
			throw new IllegalArgumentException("Must be the same length"); 
		}
		else
		{
			
			
			if (this.isRowVector)
			{
				double[][] sumFinal = new double[1][this.data.length]; 
					for(int j = 0; j < this.data.length; j++)
					{
					tempThis = this.data[0][j]; 
					tempOther = other.data[0][j]; 
					
					sum = tempThis + tempOther; 
					sumFinal[0][j] = sum; 
				}
					mySum = new MathVector(sumFinal);				
			}
			
			
			
			else if (!(this.isRowVector))
			{
				double[][] sumFinal = new double[this.data.length][1]; 
					for(int j = 0; j < this.data.length; j++)
					{
					tempThis = this.data[j][0]; 
					tempOther = other.data[j][0]; 
					
					sum = tempThis + tempOther; 
					sumFinal[j][0] = sum; 
				}
					mySum = new MathVector(sumFinal);				
			}
		}
		
		return mySum;  
	}
	
	/**
	 * Computes and returns the dot product of this vector and another vector.
	 * 
	 * @param other - another vector to be combined with this vector to produce the dot product
	 * @throws IllegalArgumentException if the other vector and this vector are not both row vectors of
	 *         the same length or column vectors of the same length
	 */	
	public double dotProduct(MathVector other) {
		
		double tempThis; 
		double tempOther; 
		double product; 
		double dotProduct = 0; 
		
		if (this.isRowVector && !(other.isRowVector) || !(this.isRowVector) && other.isRowVector)
		{
			throw new IllegalArgumentException("Must both be columns or both be rows"); 
		}
		else if (this.data.length != other.data.length || this.data[0].length != other.data[0].length)
		{
			throw new IllegalArgumentException("Must be the same length"); 
		}
		else
		{
			
			
			if (this.isRowVector)
			{
					for(int j = 0; j < this.data[0].length; j++)
					{
					tempThis = this.data[0][j]; 
					tempOther = other.data[0][j]; 
					
					product = tempThis * tempOther; 
					dotProduct = dotProduct + product; 
				}			
			}
			
			
			
			else if (!(this.isRowVector))
			{
					for(int j = 0; j < this.data.length; j++)
					{
					tempThis = this.data[j][0]; 
					tempOther = other.data[j][0]; 
					
					product = tempThis * tempOther; 
					dotProduct = dotProduct + product; 
				}		
			}
		}
		
		return dotProduct;  
		
		
	}
	
	/**
	 * Computes and returns this vector's magnitude (also known as a vector's length) .
	 */
	public double magnitude() {
		double number = 0; 
		
		if (this.isRowVector)
		{
			for(int j = 0; j < this.data[0].length; j++)
			{
				double temp = this.data[0][j]; 
				number = (temp * temp) + number; 
				
			}
		}
		
		else if (!this.isRowVector)
		{
			for(int j = 0; j < this.data.length; j++)
			{
				double temp = this.data[j][0]; 
				number = (temp * temp) + number; 
				
			}
		}
		return Math.sqrt(number); 
	}
	
	/** 
	 * Generates and returns a normalized version of this vector.
	 */
	public MathVector normalize() {
		double normalize = 0; 
		MathVector myNormal = new MathVector(data); 
		
		if (this.isRowVector)
		{
			double[][] normalFinal = new double[1][this.data.length];
			
			for(int j = 0; j < this.data.length; j++)
			{
				double temp = this.data[0][j];
				normalize = temp / this.magnitude(); 
				normalFinal[0][j] = normalize; 
			}
			myNormal = new MathVector(normalFinal); 
		}
		
		
		else if (!(this.isRowVector))
		{
			double[][] normalFinal = new double[this.data.length][1]; 
			
			for(int j = 0; j < this.data.length; j++)
			{
				double temp = this.data[j][0];
				normalize = temp / this.magnitude(); 
				normalFinal[j][0] = normalize; 
			}
			myNormal = new MathVector(normalFinal); 
		}
		
		return myNormal; 
	}
	
	/**
	 * Generates and returns a textual representation of this vector.
	 * For example, "1.0 2.0 3.0 4.0 5.0" for a sample row vector of length 5 and 
	 * "1.0
	 *  2.0
	 *  3.0
	 *  4.0
	 *  5.0" for a sample column vector of length 5. 
	 *  In both cases, notice the lack of a newline or space after the last number.
	 */
	public String toString() {
		String result = ""; 
		int i = 0; 
		int j = 0; 
		
		if(this.isRowVector)
		{
			for (i = 0; i < this.data.length; i++)
			{
				for(j = 0; j < this.data[i].length; j++)
				{
				double number = data[i][j]; 
				if (i != data.length - 1 && j != data.length -1)
				{
					result = result +  " " + Double.toString(number); 
				} 
				else
				{
				 result = result + Double.toString(number); 
				}
				}
			}
		}
		
		
		if(!this.isRowVector)
		{
			for (i = 0; i < this.data.length; i++)
			{
				for(j = 0; j < this.data[i].length; j++)
				{
				double number = data[i][j]; 
				if (i != data.length - 1 && j != data.length -1)
				{
					result = result +  Double.toString(number) + "\n"; 
				} 
				else
				{
				 result = result + Double.toString(number); 
				}
				}
			}
		}
		
		
		return result; 
	}
}
