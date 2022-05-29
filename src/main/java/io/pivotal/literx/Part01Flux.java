package io.pivotal.literx;

import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {


//========================================================================================

	// TODO Return an empty Flux
	Flux<String> emptyFlux() {
		//projectReactor
		return Flux.empty();
		//RxJava
		//Observable.empty();
	}

//========================================================================================

	// TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
	Flux<String> fooBarFluxFromValues() {

		Flux<String> flux = Flux.just("foo", "bar");
		flux.log().subscribe();

		return flux;
	}

//========================================================================================

	// TODO Create a Flux from a List that contains 2 values "foo" and "bar"
	Flux<String> fooBarFluxFromList() {

		Flux<String> value = Flux.fromIterable(Arrays.asList("foo", "bar"));
		value.log().subscribe();

		//another way to do it :D
		List<String> values = new ArrayList<>();
		values.add(new String("foo"));
		values.add(new String("bar"));
		Flux.fromIterable(values);
		return value;
	}

//========================================================================================

	// TODO Create a Flux that emits an IllegalStateException
	Flux<String> errorFlux() {

		Flux<String> error = Flux.error(new IllegalStateException("This is an illegal exception"));
		error.log().subscribe();

		return error;
	}


//========================================================================================

	// TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
	Flux<Long> counter() {

		Flux<Long> fluxLongRange = Flux.interval(Duration.ofMillis(100)).take(10);
		//Flux fluxRange = Flux.range(0,10)
		//		.delayElements(Duration.ofMillis(100));

		fluxLongRange.log().subscribe();
		return fluxLongRange;
	}


}