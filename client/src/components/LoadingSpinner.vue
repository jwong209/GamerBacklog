<!--
  LoadingSpinner component

  Shows or hides a "spinner" to show the user when the app is busy doing something, like making a call to the server.

  It has one "prop" called spin. True to show the spinner and false to hide it.

  To use this component on your page, suppose you have a data property called isLoading. 
  You set `isLoading = true` before issuing an asynchronous call (using axios for example). 
  And when the call completes, you set `isLoading = false`. 

  When you include the component, set the "spin" prop to the value of isLoading (or whatever your data property is). So
  to include this LoadingSpinner, add the component to your page like this:
  
    <loading-spinner id="spinner" v-bind:spin="isLoading" />

  When isLoading === true, the component will display, else it will be hidden (opacity = 0).
-->
<template>
	<div>
		<!-- <font-awesome-icon
    v-bind:style="{ opacity: spin ? 1 : 0 }"
    icon="fa-solid fa-rotate"
    class="load-spinner fa-spin"
    /> -->

		<svg class="pl2" viewBox="0 0 128 128" width="128px" height="128px">
			<g fill="hsl(233,90%,50%)">
				<g class="pl2__rect-g">
					<rect class="pl2__rect" rx="8" ry="8" x="0" y="128" width="40" height="24" transform="rotate(180)" />
				</g>
				<g class="pl2__rect-g">
					<rect class="pl2__rect" rx="8" ry="8" x="44" y="128" width="40" height="24" transform="rotate(180)" />
				</g>
				<g class="pl2__rect-g">
					<rect class="pl2__rect" rx="8" ry="8" x="88" y="128" width="40" height="24" transform="rotate(180)" />
				</g>
			</g>
			<g fill="hsl(192,90%,50%)" mask="url(#pl-mask)">
				<g class="pl2__rect-g">
					<rect class="pl2__rect" rx="8" ry="8" x="0" y="128" width="40" height="24" transform="rotate(180)" />
				</g>
				<g class="pl2__rect-g">
					<rect class="pl2__rect" rx="8" ry="8" x="44" y="128" width="40" height="24" transform="rotate(180)" />
				</g>
				<g class="pl2__rect-g">
					<rect class="pl2__rect" rx="8" ry="8" x="88" y="128" width="40" height="24" transform="rotate(180)" />
				</g>
			</g>
		</svg>

	</div>


	<!-- credits to Jon Kantner, https://codepen.io/jkantner/pen/YzdpEVO?editors=1100 -->
</template>

<script>
export default {
	props: {
		spin: {
			type: Boolean,
			required: true,
		},
	},
};
</script>

<style scoped>
.load-spinner {
	transition-property: opacity;
	transition-duration: 400ms;
	font-size: 40px;
}


div {
	display: flex;
	height: 100px;
	margin: 20px auto;
	justify-content: center;
}


.pl2 {
	display: block;
	width: 4em;
	height: 4em;
}

.pl2__rect,
.pl2__rect-g {
	animation: pl1-a 1.5s cubic-bezier(0.65, 0, 0.35, 1) infinite;
}

.pl2__rect,
.pl2__rect-g {
	animation-name: pl2-a;
}

.pl2__rect {
	animation-name: pl2-b;
}

.pl2__rect-g .pl2__rect {
	transform-origin: 20px 128px;
}

.pl2__rect-g:first-child,
.pl2__rect-g:first-child .pl2__rect {
	animation-delay: -0.25s;
}

.pl2__rect-g:nth-child(2),
.pl2__rect-g:nth-child(2) .pl2__rect {
	animation-delay: -0.125s;
}

.pl2__rect-g:nth-child(2) .pl2__rect {
	transform-origin: 64px 128px;
}

.pl2__rect-g:nth-child(3) .pl2__rect {
	transform-origin: 108px 128px;
}

.pl3__rect {
	animation-name: pl3;
}

.pl3__rect-g {
	transform-origin: 64px 64px;
}



/* Animations */
@keyframes pl1-a {
	from {
		transform: rotate(0);
	}

	80%,
	to {
		animation-timing-function: steps(1, start);
		transform: rotate(90deg);
	}
}

@keyframes pl1-b {
	from {
		animation-timing-function: cubic-bezier(0.33, 0, 0.67, 0);
		width: 40px;
		height: 40px;
	}

	20% {
		animation-timing-function: steps(1, start);
		width: 40px;
		height: 0;
	}

	60% {
		animation-timing-function: cubic-bezier(0.65, 0, 0.35, 1);
		width: 0;
		height: 40px;
	}

	80%,
	to {
		width: 40px;
		height: 40px;
	}
}

@keyframes pl1-c {
	from {
		animation-timing-function: cubic-bezier(0.33, 0, 0.67, 0);
		width: 40px;
		height: 40px;
		transform: translate(0, 48px);
	}

	20% {
		animation-timing-function: cubic-bezier(0.33, 1, 0.67, 1);
		width: 40px;
		height: 88px;
		transform: translate(0, 0);
	}

	40% {
		animation-timing-function: cubic-bezier(0.33, 0, 0.67, 0);
		width: 40px;
		height: 40px;
		transform: translate(0, 0);
	}

	60% {
		animation-timing-function: cubic-bezier(0.33, 1, 0.67, 1);
		width: 88px;
		height: 40px;
		transform: translate(0, 0);
	}

	80%,
	to {
		width: 40px;
		height: 40px;
		transform: translate(48px, 0);
	}
}

@keyframes pl2-a {

	from,
	25%,
	66.67%,
	to {
		transform: translateY(0);
	}

	50% {
		animation-timing-function: cubic-bezier(0.33, 0, 0.67, 0);
		transform: translateY(-80px);
	}
}

@keyframes pl2-b {

	from,
	to {
		animation-timing-function: cubic-bezier(0.33, 0, 0.67, 0);
		width: 40px;
		height: 24px;
		transform: rotate(180deg) translateX(0);
	}

	33.33% {
		animation-timing-function: cubic-bezier(0.33, 1, 0.67, 1);
		width: 20px;
		height: 64px;
		transform: rotate(180deg) translateX(10px);
	}

	66.67% {
		animation-timing-function: cubic-bezier(0.33, 1, 0.67, 1);
		width: 28px;
		height: 44px;
		transform: rotate(180deg) translateX(6px);
	}
}

@keyframes pl3 {
	from {
		transform: translate(64px, 0);
		width: 64px;
		height: 64px;
	}

	25% {
		transform: translate(0, 0);
		width: 128px;
		height: 32px;
	}

	50% {
		transform: translate(0, 0);
		width: 64px;
		height: 64px;
	}

	75% {
		transform: translate(0, 0);
		width: 32px;
		height: 128px;
	}

	to {
		transform: translate(0, 64px);
		width: 64px;
		height: 64px;
	}

}</style>