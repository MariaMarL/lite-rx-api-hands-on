package io.pivotal.literx;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {

//========================================================================================

	// TODO Return an empty Mono
	Mono<String> emptyMono() {

		Mono<String> mono = Mono.empty();
		mono.log().subscribe();

		return mono;

	}
//========================================================================================

	// TODO Return a Mono that never emits any signal
	Mono<String> monoWithNoSignal() {
		Mono<String> mono = Mono.never();
		mono.log().subscribe();

		return mono;
	}

//========================================================================================

	// TODO Return a Mono that contains a "foo" value
	Mono<String> fooMono() {

		Mono<String> mono = Mono.just("foo");

		return mono;
	}
//========================================================================================

	// TODO Create a Mono that emits an IllegalStateException
	Mono<String> errorMono() {
		Mono<String> mono = Mono.error(new IllegalStateException("This is an illegal exception"));
		mono.log().subscribe();

		return mono;

	}

}
