package com.md;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.md.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception
	{
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable String numberOne, @PathVariable String nuberTwo) throws Exception
	{
		System.out.println("numberOne: " + numberOne);
		System.out.println("numberOne: " + nuberTwo);
		return convertToDouble(numberOne) - convertToDouble(nuberTwo);
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception
	{
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double divison(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception
	{
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable String number) throws Exception
	{
		return Math.sqrt(convertToDouble(number));
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception
	{
		return ((convertToDouble(numberOne) + convertToDouble(numberTwo) / 2));
	}

	private double convertToDouble(String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Double.valueOf(number);
	}

	private boolean isNumeric(String number) {
		if (number == null) return false;
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

}