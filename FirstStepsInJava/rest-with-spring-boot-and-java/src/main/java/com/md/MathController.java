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
		return convertToDouble(numberTwo) + convertToDouble(numberOne);
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