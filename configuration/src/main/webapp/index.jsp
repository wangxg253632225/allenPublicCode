<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="text/javascript">
			window.NREUM || (NREUM = {});
			NREUM.info = {
				"beacon": "bam.nr-data.net",
				"errorBeacon": "bam.nr-data.net",
				"licenseKey": "c9b664e707",
				"applicationID": "11277660",
				"transactionName": "d1hfRxZXWlhdExoSUFNSQhwWV1lA",
				"queueTime": 4,
				"applicationTime": 23,
				"agent": ""
			}
		</script>
		<script type="text/javascript">
			window.NREUM || (NREUM = {}), __nr_require = function(e, n, t) {
				function r(t) {
					if(!n[t]) {
						var o = n[t] = {
							exports: {}
						};
						e[t][0].call(o.exports, function(n) {
							var o = e[t][1][n];
							return r(o || n)
						}, o, o.exports)
					}
					return n[t].exports
				}
				if("function" == typeof __nr_require) return __nr_require;
				for(var o = 0; o < t.length; o++) r(t[o]);
				return r
			}({
				1: [function(e, n, t) {
					function r() {}

					function o(e, n, t) {
						return function() {
							return i(e, [c.now()].concat(u(arguments)), n ? null : this, t), n ? void 0 : this
						}
					}
					var i = e("handle"),
						a = e(2),
						u = e(3),
						f = e("ee").get("tracer"),
						c = e("loader"),
						s = NREUM;
					"undefined" == typeof window.newrelic && (newrelic = s);
					var p = ["setPageViewName", "setCustomAttribute", "setErrorHandler", "finished", "addToTrace", "inlineHit", "addRelease"],
						d = "api-",
						l = d + "ixn-";
					a(p, function(e, n) {
						s[n] = o(d + n, !0, "api")
					}), s.addPageAction = o(d + "addPageAction", !0), s.setCurrentRouteName = o(d + "routeName", !0), n.exports = newrelic, s.interaction = function() {
						return(new r).get()
					};
					var m = r.prototype = {
						createTracer: function(e, n) {
							var t = {},
								r = this,
								o = "function" == typeof n;
							return i(l + "tracer", [c.now(), e, t], r),
								function() {
									if(f.emit((o ? "" : "no-") + "fn-start", [c.now(), r, o], t), o) try {
										return n.apply(this, arguments)
									} finally {
										f.emit("fn-end", [c.now()], t)
									}
								}
						}
					};
					a("setName,setAttribute,save,ignore,onEnd,getContext,end,get".split(","), function(e, n) {
						m[n] = o(l + n)
					}), newrelic.noticeError = function(e) {
						"string" == typeof e && (e = new Error(e)), i("err", [e, c.now()])
					}
				}, {}],
				2: [function(e, n, t) {
					function r(e, n) {
						var t = [],
							r = "",
							i = 0;
						for(r in e) o.call(e, r) && (t[i] = n(r, e[r]), i += 1);
						return t
					}
					var o = Object.prototype.hasOwnProperty;
					n.exports = r
				}, {}],
				3: [function(e, n, t) {
					function r(e, n, t) {
						n || (n = 0), "undefined" == typeof t && (t = e ? e.length : 0);
						for(var r = -1, o = t - n || 0, i = Array(o < 0 ? 0 : o); ++r < o;) i[r] = e[n + r];
						return i
					}
					n.exports = r
				}, {}],
				4: [function(e, n, t) {
					n.exports = {
						exists: "undefined" != typeof window.performance && window.performance.timing && "undefined" != typeof window.performance.timing.navigationStart
					}
				}, {}],
				ee: [function(e, n, t) {
					function r() {}

					function o(e) {
						function n(e) {
							return e && e instanceof r ? e : e ? f(e, u, i) : i()
						}

						function t(t, r, o, i) {
							if(!d.aborted || i) {
								e && e(t, r, o);
								for(var a = n(o), u = m(t), f = u.length, c = 0; c < f; c++) u[c].apply(a, r);
								var p = s[y[t]];
								return p && p.push([b, t, r, a]), a
							}
						}

						function l(e, n) {
							v[e] = m(e).concat(n)
						}

						function m(e) {
							return v[e] || []
						}

						function w(e) {
							return p[e] = p[e] || o(t)
						}

						function g(e, n) {
							c(e, function(e, t) {
								n = n || "feature", y[t] = n, n in s || (s[n] = [])
							})
						}
						var v = {},
							y = {},
							b = {
								on: l,
								emit: t,
								get: w,
								listeners: m,
								context: n,
								buffer: g,
								abort: a,
								aborted: !1
							};
						return b
					}

					function i() {
						return new r
					}

					function a() {
						(s.api || s.feature) && (d.aborted = !0, s = d.backlog = {})
					}
					var u = "nr@context",
						f = e("gos"),
						c = e(2),
						s = {},
						p = {},
						d = n.exports = o();
					d.backlog = s
				}, {}],
				gos: [function(e, n, t) {
					function r(e, n, t) {
						if(o.call(e, n)) return e[n];
						var r = t();
						if(Object.defineProperty && Object.keys) try {
							return Object.defineProperty(e, n, {
								value: r,
								writable: !0,
								enumerable: !1
							}), r
						} catch(i) {}
						return e[n] = r, r
					}
					var o = Object.prototype.hasOwnProperty;
					n.exports = r
				}, {}],
				handle: [function(e, n, t) {
					function r(e, n, t, r) {
						o.buffer([e], r), o.emit(e, n, t)
					}
					var o = e("ee").get("handle");
					n.exports = r, r.ee = o
				}, {}],
				id: [function(e, n, t) {
					function r(e) {
						var n = typeof e;
						return !e || "object" !== n && "function" !== n ? -1 : e === window ? 0 : a(e, i, function() {
							return o++
						})
					}
					var o = 1,
						i = "nr@id",
						a = e("gos");
					n.exports = r
				}, {}],
				loader: [function(e, n, t) {
					function r() {
						if(!x++) {
							var e = h.info = NREUM.info,
								n = d.getElementsByTagName("script")[0];
							if(setTimeout(s.abort, 3e4), !(e && e.licenseKey && e.applicationID && n)) return s.abort();
							c(y, function(n, t) {
								e[n] || (e[n] = t)
							}), f("mark", ["onload", a() + h.offset], null, "api");
							var t = d.createElement("script");
							t.src = "https://" + e.agent, n.parentNode.insertBefore(t, n)
						}
					}

					function o() {
						"complete" === d.readyState && i()
					}

					function i() {
						f("mark", ["domContent", a() + h.offset], null, "api")
					}

					function a() {
						return E.exists && performance.now ? Math.round(performance.now()) : (u = Math.max((new Date).getTime(), u)) - h.offset
					}
					var u = (new Date).getTime(),
						f = e("handle"),
						c = e(2),
						s = e("ee"),
						p = window,
						d = p.document,
						l = "addEventListener",
						m = "attachEvent",
						w = p.XMLHttpRequest,
						g = w && w.prototype;
					NREUM.o = {
						ST: setTimeout,
						SI: p.setImmediate,
						CT: clearTimeout,
						XHR: w,
						REQ: p.Request,
						EV: p.Event,
						PR: p.Promise,
						MO: p.MutationObserver
					};
					var v = "" + location,
						y = {
							beacon: "bam.nr-data.net",
							errorBeacon: "bam.nr-data.net",
							agent: "js-agent.newrelic.com/nr-1059.min.js"
						},
						b = w && g && g[l] && !/CriOS/.test(navigator.userAgent),
						h = n.exports = {
							offset: u,
							now: a,
							origin: v,
							features: {},
							xhrWrappable: b
						};
					e(1), d[l] ? (d[l]("DOMContentLoaded", i, !1), p[l]("load", r, !1)) : (d[m]("onreadystatechange", o), p[m]("onload", r)), f("mark", ["firstbyte", u], null, "api");
					var x = 0,
						E = e(4)
				}, {}]
			}, {}, ["loader"]);
		</script>
		<title>HRabbit</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
		<link rel="apple-touch-icon-precomposed" sizes="57x57" href="apple-touch-icon-57x57.png" />
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="apple-touch-icon-114x114.png" />
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="apple-touch-icon-72x72.png" />
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="apple-touch-icon-144x144.png" />
		<link rel="apple-touch-icon-precomposed" sizes="60x60" href="apple-touch-icon-60x60.png" />
		<link rel="apple-touch-icon-precomposed" sizes="120x120" href="apple-touch-icon-120x120.png" />
		<link rel="apple-touch-icon-precomposed" sizes="76x76" href="apple-touch-icon-76x76.png" />
		<link rel="apple-touch-icon-precomposed" sizes="152x152" href="apple-touch-icon-152x152.png" />
		<link rel="icon" type="image/png" href="favicon-196x196.png" sizes="196x196" />
		<link rel="icon" type="image/png" href="favicon-96x96.png" sizes="96x96" />
		<link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" />
		<link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
		<link rel="icon" type="image/png" href="favicon-128.png" sizes="128x128" />
		<meta name="application-name" content="&nbsp;" />
		<meta name="msapplication-TileColor" content="#FFFFFF" />
		<meta name="msapplication-TileImage" content="/mstile-144x144.png" />
		<meta name="msapplication-square70x70logo" content="/mstile-70x70.png" />
		<meta name="msapplication-square150x150logo" content="/mstile-150x150.png" />
		<meta name="msapplication-wide310x150logo" content="/mstile-310x150.png" />
		<meta name="msapplication-square310x310logo" content="/mstile-310x310.png" />
		<meta name="theme-color" content="#ffffff">

		<link rel="stylesheet" media="all" href="assets/marketing-cad7960d8bc7410d23cfdd6c682b762fe27f7844f44c71659bde9934afe2daaf.css" data-turbolinks-track="true" />

	</head>

	<body class="">
		<div class="bg-white">

			<nav class="navbar navbar-primary">
				<div class="container">

					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar-collapse" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
						<a class="navbar-brand" href="index.html">
							<img alt="Coach" src="assets/marketing/coach-logo-full-c0676f606766a065d8394e7d0944464ea4451ff13780f116f4ac0610d0086937.svg" />
						</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div id="header-navbar-collapse" class="collapse navbar-collapse">
						<div class=" navbar-right">
							<ul class="nav navbar-nav">
								<li class="">
									<a href="features.html">Features</a>
								</li>
								<li class="">
									<a href="examples.html">Examples</a>
								</li>
								<li class="">
									<a href="pricing.html">Pricing</a>
								</li>
								<li class="">
									<a href="login.html">Login</a>
								</li>
							</ul>
							<a class="btn btn-primary btn-sm navbar-btn" href="signup.html">Sign up</a>
						</div>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>

			<div class='container'>
				<div class='home-hero text-center-xs mt5-xs mb7 mb3-xs'>
					<div class='row v-center'>
						<div class='col-sm-6'>
							<div class='ph6 pt6 pt0-sm pt0-xs'>
								<h1 class='ma0'>
Make a living off
<br class='hidden-xs'>
your passion
</h1>
								<p class='lead mt4 mb5'>Sell online courses and digital products from your own beautiful storefront in seconds.</p>
								<a class="btn btn-primary block-xs" href="signup.html">Get started</a>
							</div>
						</div>
						<div class='col-sm-6'>
							<div class='ph6 mt6-xs ph0-xs'>
								<img class="img-responsive center-block" style="max-width: 460px;" src="assets/marketing/profit-fbdeecd9d18c4e8a01edc3018d229e7df504e77153b64679d66cb03973eda702.svg" alt="Profit" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class='bg-gray-super-light curve-container'>
				<div class='curve'></div>
				<div class='container'>
					<div class='row'>
						<div class='col-md-6 col-sm-12'>
							<div class='bg-white shadow-box pa6 home-shadow-box clearfix'>
								<img width="70" src="assets/marketing/icon-online-courses-395d0511cd9764c0ac81902ba76640884821fb1c1554f9909d9bcff6963ab968.svg" alt="Icon online courses" />
								<div class='text pl5'>
									<h3 class='mt0 mb3 text-w-700'>Online courses</h3>
									<p class='ma0'>Beautiful, customizable, and easy-to-use. Plus, we’ll migrate your existing content for free.</p>
								</div>
							</div>
						</div>
						<div class='col-md-6 col-sm-12'>
							<div class='bg-white shadow-box pa6 home-shadow-box clearfix'>
								<img width="70" src="assets/marketing/icon-digital-downloads-5e2d91a607c4b3135b6338b28a45bc553d98ed72f8b28f70bb54e01220ae876b.svg" alt="Icon digital downloads" />
								<div class='text pl5'>
									<h3 class='mt0 mb3 text-w-700'>Digital products</h3>
									<p class='ma0'>Sell anything you want, from PDFs and eBooks to guides, templates, and more.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class='bg-gray-super-light section home-storefront'>
				<div class='container'>
					<div class='row v-center'>
						<div class='col-sm-6 col-md-7 col-storefront mb6-xs'>
							<img src="assets/marketing/storefront-cc01d3030d5cfa91d4ded3e09e6e5f59002f3fc13670564647147eca4b4a06b9.png" alt="Storefront" />
						</div>
						<div class='col-sm-6 col-md-5 col-text'>
							<div class='text-center-xs'>
								<h3 class='mt0 mb3 text-w-700'>Build your own storefront</h3>
								<p class='mt0 mb6'>Upload your online course or digital product, then customize your storefront and sales pages however you want. We’ll even migrate your existing content for free.</p>
							</div>
							<div class='media'>
								<div class='media-left'>
									<img width="72" height="72" src="assets/marketing/testimonials/justin-c7dac12e638b991754b69206dbda8a18dbc1a6d8fa0db0fbf31ae8468339012a.png" alt="Justin" />
								</div>
								<div class='media-right'>
									<div class='text-primary text-w-700 text-xs text-uppercase mb2'>Justin Jackson</div>
									<p class='text-darkest'>“Coach lets me show off my product and personality in a way that helps me connect with my customers”</p>
									<a target="blank" class="text-w-700" href="https://justinjackson.withcoach.com/">View Justin's storefront &rarr;</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class='bg-white pt10 pt6-xs'>
				<div class='container'>
					<div class='present-your-product'>
						<div class='present-your-product-content'>
							<div class='text-center-sm text-center-xs pt6-lg mb6-sm mb6-xs ph6-sm'>
								<h3 class='mt0 mb3 text-w-700'>Present your product beautifully</h3>
								<p class='text-lg mt0 mb5'>
									Teach your audience everything you know with a beautifully-designed online course reader that makes learning look easy.
								</p>
								<a target="blank" class="text-w-700" href="features/online-course-builder.html">Check out our course platform &rarr;</a>
							</div>
							<img class="img-responsive center-block visible-lg-block" src="assets/marketing/tribe-cropped-378fc9482928d00c4d22c0a65e056ab3a82bb090c55ff6b54152c962b9c23a4d.svg" alt="Tribe cropped" />
						</div>
						<div class='present-your-product-graphic'>
							<a target="blank" class="text-w-700" href="features/online-course-builder.html"><img src="assets/marketing/course-reader-8fc5ae896762f6dd49ab1a7f70d769157a5d2ba2c4437c73bc5d4bc68fa0a6a1.png" alt="Course reader" />
							</a>
						</div>
					</div>
				</div>
			</div>

			<div class='section bg-confetti-dark'>
				<div class='container'>
					<div class='row v-center'>
						<div class='col-md-6 col-md-push-6' style='border: 0px solid red;'>
							<img class="img-responsive center-block" src="assets/marketing/paid2-b386e01e4d534734888d5e85f6e7e399476fce31e5a15ae60db72358c210a965.svg" alt="Paid2" />
							<div class='text-center-xs mv6-xs mt5-sm mt6-md ph6-md mt6-lg pr7-lg pl8-lg'>
								<h3 class='text-white mt0 mb3 text-w-700'>The easiest checkout ever</h3>
								<p class='text-muted ma0'>No name, no password, no friction. Just an email address and credit card is all that’s required for purchasing (woohoo!).</p>
							</div>
						</div>
						<div class='col-md-6 col-md-pull-6' style='border: 0px solid red;'>
							<img class="img-responsive center-block" src="assets/marketing/checkout-modal-f4185217e18101245b9e5778d73474afb7a9d7885f6fd75250c46f38af3feb54.png" alt="Checkout modal" />
						</div>
					</div>
				</div>
			</div>
			<div class='bg-primary pv7'>
				<div class='container'>
					<div class='row'>
						<div class='col-md-6'>
							<div class='media'>
								<div class='media-left media-middle'>
									<img class="img-border-white img-circle" width="110" height="110" src="assets/marketing/face-alvin-8916ac186f8f5c51a21d0628e2677fac6fd194e65d260c92a56deec54aad4a53.png" alt="Face alvin" />
								</div>
								<div class='media-right'>
									<div class='text-darkest text-sm text-uppercase text-w-700 mb3'>Alvin Milton</div>
									<p class='mb3'>&ldquo;I pivoted from a brick & mortar to Coach & it was frictionless. I now have my first online course.&rdquo;</p>
									<a target="blank" class="text-w-700 text-white" href="https://bytes.withcoach.com/building-web-pages">View Alvin's course &rarr;</a>
								</div>
							</div>
						</div>
						<div class='col-md-6'>
							<div class='media mt7-xs mt7-sm'>
								<div class='media-left media-middle'>
									<img class="img-border-white img-circle" width="110" height="110" src="assets/marketing/face-rachel-b92a062bfb1b65fb72350bcaad3740a085be7a67d7f0150aa9a66b0e547e5396.png" alt="Face rachel" />
								</div>
								<div class='media-right'>
									<div class='text-darkest text-sm text-uppercase text-w-700 mb3'>Rachel Shillcock</div>
									<p class='mb3'>&ldquo;Coach helps me focus on what matters most: building my brand and creating work of real value.&rdquo;</p>
									<a target="blank" class="text-w-700 text-white" href="https://learn.rachilli.com/">View Rachel's products &rarr;</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class='container'>
				<div class='mt8'>
					<div class='offset-base'></div>
					<div class='available-plans'>
						<div class='text-center'>
							<h1 class='ma0'>Plans for every passion</h1>
							<p class='large mt5 mb0'>Get the tools and support needed to build your business, so you can create the life you want.</p>
							<div class='available-plans-toggle-interval'>
								<a class="active no-underline" data-interval="yearly" href="index.html#year-plans">Annual billing</a>
								<a class="no-underline" data-interval="monthly" href="index.html#month-plans">Monthly billing</a>
							</div>
							<div class='available-plans-plan-container'>
								<div class='pricing-table-plan'>
									<div class='pricing-table-plan-header pa6'>
										<h4 class='text-uppercase mt4 mb4'>Mover</h4>
										<p class='ma0 ph4'>You want to get your business moving and you’re ready to see results.</p>
									</div>
									<div class='pricing-table-plan-price-info'>
										<div class='yearly'>
											<div class="pricing-table-monthly-price"><sup>$</sup><span>32</span><small> / mo</small></div>
										</div>
										<div class='monthly'>
											<div class="pricing-table-monthly-price"><sup>$</sup><span>39</span><small> / mo</small></div>
										</div>
										0% Coach fee
										<div class='yearly mt6'>
											<small>
Billed annually
<br>
(Or
$39/mo
billed monthly)
</small>
										</div>

									</div>
									<div class='pricing-table-plan-button mv6'>
										<div class='yearly'>
											<a class="btn btn-primary" href="signup.html">Start your trial</a>
										</div>
										<div class='monthly'>
											<a class="btn btn-primary" href="signup.html">Start your trial</a>
										</div>
									</div>
									<div class='pricing-table-plan-features pa6 bg-lightest'>
										<ul class='plan-features text-left ma0'>
											<li class='text-darkest'>All basic Coach features</li>
											<li class='text-darkest'>Drip course content</li>
										</ul>
									</div>
								</div>
								<div class='pricing-table-plan'>
									<div class='pricing-table-plan-header pa6'>
										<h4 class='text-uppercase mt4 mb4'>Shaker</h4>
										<p class='ma0 ph4'>You're ready to shake things up by scaling your most successful products.</p>
									</div>
									<div class='pricing-table-plan-price-info'>
										<div class='yearly'>
											<div class="pricing-table-monthly-price"><sup>$</sup><span>65</span><small> / mo</small></div>
										</div>
										<div class='monthly'>
											<div class="pricing-table-monthly-price"><sup>$</sup><span>79</span><small> / mo</small></div>
										</div>
										0% Coach fee
										<div class='yearly mt6'>
											<small>
Billed annually
<br>
(Or
$79/mo
billed monthly)
</small>
										</div>

									</div>
									<div class='pricing-table-plan-button mv6'>
										<div class='yearly'>
											<a class="btn btn-primary" href="signup.html">Start your trial</a>
										</div>
										<div class='monthly'>
											<a class="btn btn-primary" href="signup.html">Start your trial</a>
										</div>
									</div>
									<div class='pricing-table-plan-features pa6 bg-lightest'>
										<ul class='plan-features text-left ma0'>
											<li class='text-darkest'>All basic Coach features</li>
											<li class='text-darkest'>Advanced tracking</li>
											<li class='text-darkest'>Onboarding + migration assistance</li>
											<li class='text-darkest'>Drip course content</li>
											<li class='text-darkest'>Affiliates</li>
											<li>
												Memberships (
												<a href="features/memberships.html">coming soon!</a>)
											</li>
										</ul>
									</div>
								</div>
								<div class='pricing-table-plan bg-lightest earthquaker'>
									<div class='pricing-table-plan-header pa6'>
										<h4 class='text-uppercase mt4 mb4'>Earthquaker</h4>
										<p class='ma0 ph4'>You're an 8 on the richter scale, but you wanna be a 10. Let's do this.</p>
									</div>
									<div class='pricing-table-plan-price-info'>
										<p class='lead'>Contact us for pricing</p>
									</div>
									<div class='pricing-table-plan-button mv6'>
										<a class="btn btn-primary" href="enterprise.html">Learn more</a>
									</div>
									<div class='pricing-table-plan-features pa6 bg-lightest'>
										<ul class='plan-features text-left ma0'>
											<li class='text-darkest'>All basic Coach features</li>
											<li class='text-darkest'>All "Shaker" features</li>
											<li class='text-darkest'>White labeling</li>
											<li>Team licenses (coming soon!)</li>
											<li>Multiple users (coming soon!)</li>
											<li>ACH payments (coming soon!)</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class='all-plans-include mt8'>
						<h3 class='text-center'>All plans include</h3>
						<div class='all-plans-features'>
							<div class='feature'>
								<h5>Unlimited courses</h5>
								<p>No limits on courses, files, or bandwidth. Total creative freedom.</p>
							</div>
							<div class='feature'>
								<h5>Unlimited digital downloads</h5>
								<p>Anything goes: PDFs, guides, templates, audio files, and more.</p>
							</div>
							<div class='feature'>
								<h5>Email newsletters</h5>
								<p>Send weekly, monthly, or one-off email newsletters to your audience.</p>
							</div>
							<div class='feature'>
								<h5>Drip email marketing</h5>
								<p>Setup automated drip emails for your products or landing pages.</p>
							</div>
							<div class='feature'>
								<h5>Landing pages</h5>
								<p>Capture email addresses with landing pages and email opt-in forms.</p>
							</div>
							<div class='feature'>
								<h5>Customer tracking</h5>
								<p>Activity feed, sales notifications, and Google Analytics data.</p>
							</div>
							<div class='feature'>
								<h5>High-conversion checkout</h5>
								<p>Convert more customers with our simple checkout (best on the market!).</p>
							</div>
							<div class='feature'>
								<h5>Integrations</h5>
								<p>Use Zapier or ConvertKit for email marketing and more.</p>
							</div>
							<div class='feature'>
								<h5>Custom domain</h5>
								<p>Sell your products from your own website.</p>
							</div>
							<div class='feature'>
								<h5>Instant payouts</h5>
								<p>Money is deposited directly into your bank account.</p>
							</div>
							<div class='feature'>
								<h5>Payment protection</h5>
								<p>All payments are encrypted with an SSL certificate for secure protection.</p>
							</div>
							<div class='feature'>
								<h5>Data exporting</h5>
								<p>Export any of your data, from revenue to customer email addresses.</p>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class='mt8'>
				<div class='guarantee bg-primary pv6 text-center-xs'>
					<div class='container'>
						<div class='row v-center'>
							<div class='col-sm-5'>
								<div class='mr4'><img class="img-responsive" src="assets/marketing/guarantee-badge-79a1b236e47f3dc0bf2bc86dd9402ec98fcbaf9154d7a7cf996a00a4d180753b.svg" alt="Guarantee badge" /></div>
							</div>
							<div class='col-sm-7'>
								<div class='mr4'>
									<h2 class='mt6-xs'>30 day money back guarantee</h2>
									<p>If you&#39;re unhappy for any reason (we&#39;re confident you won&#39;t be) we offer a full 30 day money back guarantee.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class='container'>
				<div class='pv8 mt6'>
					<div class='row'>
						<div class='col-sm-12'>
							<div class='section-header text-center'>
								<h2>We don’t like to talk about ourselves</h2>
								<p>But we don’t mind if our customers do ;-)</p>
							</div>
						</div>
					</div>
					<div class='testimonial-list'>
						<div class='row'>
							<div class='col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2'>
								<div class='testimonial'>
									<blockquote>
										<p>After producing over 12 courses on Game Dev, NO platform has ever supported my business the way Coach does. You don&#39;t want to miss this!</p>
									</blockquote>
									<cite>
<img width="40" height="40" class="img-circle" src="assets/marketing/testimonials/jeremy-a9a08100c4d3576583350786e6c388e02b38e6510a8de84575c81c5be01cc4eb.jpg" alt="Jeremy" />
<small>
<strong>
<a target="_blank" class="text-muted" href="https://www.jerementor.com/">Jeremy Alexander
&mdash;
Online entrepreneur
</a></strong>
</small>
</cite>
								</div>

							</div>
						</div>
						<div class='row'>
							<div class='col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2'>
								<div class='testimonial'>
									<blockquote>
										<p>I love Coach. It lets me focus on producing the course, not the delivery of it. I can spend more time teaching and helping customers.</p>
									</blockquote>
									<cite>
<img width="40" height="40" class="img-circle" src="assets/marketing/testimonials/chris-587c3c128d350ae5de1a3732f5165adc4bb8d0b66cb1fbd38586d12995b91cc9.jpg" alt="Chris" />
<small>
<strong>
<a target="_blank" class="text-muted" href="https://courses.gorails.com/">Chris Oliver
&mdash;
Ruby on Rails web developer
</a></strong>
</small>
</cite>
								</div>

							</div>
						</div>
						<div class='row'>
							<div class='col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2'>
								<div class='testimonial'>
									<blockquote>
										<p>Coach is perfect for me. The design is easy and looks great. All I have to do is concentrate on my course. It&#39;s been a such an excellent tool for my business!</p>
									</blockquote>
									<cite>
<img width="40" height="40" class="img-circle" src="assets/marketing/testimonials/meighan-4c8dd23ddc8543d209e181535137272a3ee3ef4898c74d05300571613ebfb4b9.jpg" alt="Meighan" />
<small>
<strong>
<a target="_blank" class="text-muted" href="https://meighanotoole.withcoach.com/">Meighan O&#39;Toole
&mdash;
Creative online strategist
</a></strong>
</small>
</cite>
								</div>

							</div>
						</div>
						<div class='row'>
							<div class='col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2'>
								<div class='testimonial'>
									<blockquote>
										<p>Just moved to Coach to set up my online #knitdesign course business - so much help and personalized attention - I couldn&#39;t be happier!</p>
									</blockquote>
									<cite>
<img width="40" height="40" class="img-circle" src="assets/marketing/testimonials/corrina-addc18b779b0c50f3edf35ad352c857bed17ed5dd758d5083c9a21ea62ac8752.jpg" alt="Corrina" />
<small>
<strong>
<a target="_blank" class="text-muted" href="https://picnicknits.withcoach.com/">Corrina Ferguson
&mdash;
Knitting designer &amp; teacher
</a></strong>
</small>
</cite>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<footer class='footer-primary'>
			<div class='container'>
				<div class='row text-center-xs'>
					<div class='col-sm-3'>
						<a href="index.html"><img class="logo" src="assets/marketing/coach-logo-white-f416894b5cbda978d60ea1f1d3747d98ce42ae9d0374f0f0cd44d6e1d24b053c.svg" alt="Coach logo white" />
						</a>
						<div class='mt6'>
							<a target="_blank" data-toggle="tooltip" title="Follow us on Twitter" class="img-link" href="https://twitter.com/withcoach"><img class="pr4" src="assets/marketing/social-footer-twitter-4bd3cd43d0e9bc38277433eafc83164113a50aee83d70f03a969fa98e861adc8.svg" alt="Social footer twitter" />
							</a>
							<a target="_blank" data-toggle="tooltip" title="Follow us on Facebook" class="img-link" href="https://www.facebook.com/withcoach"><img src="assets/marketing/social-footer-facebook-658e829eb30a8884fa6a4cebaf91dd915603a48c9d402266e68457c38d41e29d.svg" alt="Social footer facebook" />
							</a>
						</div>
					</div>
					<div class='col-sm-3 mt6-xs'>
						<h6 class='h-bold'>Features</h6>
						<ul class='list-unstyled'>
							<li>
								<a href="features/online-course-builder.html">Online course builder</a>
							</li>
							<li>
								<a href="features/digital-downloads.html">Digital downloads</a>
							</li>
							<li>
								<a href="features/landing-page-builder.html">Landing page builder</a>
							</li>
							<li>
								<a href="features/email-newsletter.html">Email newsletter</a>
							</li>
							<li>
								<a href="features/drip-email-marketing.html">Drip email marketing</a>
							</li>
							<li>
								<a href="features/memberships.html">Memberships</a>
							</li>
						</ul>
					</div>
					<div class='col-sm-2 mt6-xs'>
						<h6 class='h-bold'>Coach</h6>
						<ul class='list-unstyled'>
							<li>
								<a href="features.html">Features</a>
							</li>
							<li>
								<a href="pricing.html">Pricing</a>
							</li>
							<li>
								<a href="examples.html">Examples</a>
							</li>
							<li>
								<a href="enterprise.html">Enterprise</a>
							</li>
							<li>
								<a href="stories.html">Stories</a>
							</li>
							<li>
								<a target="_blank" href="http://blog.withcoach.com/">Blog</a>
							</li>
							<li>
								<a href="about.html">About us</a>
							</li>
						</ul>
					</div>
					<div class='col-sm-2 mt6-xs'>
						<h6 class='h-bold'>Compare</h6>
						<ul class='list-unstyled mb4'>
							<li>
								<a href="gumroad-alternative.html">Gumroad</a>
							</li>
							<li>
								<a href="kajabi-alternative.html">Kajabi</a>
							</li>
							<li>
								<a href="learndash-alternative.html">LearnDash</a>
							</li>
							<li>
								<a href="teachable-alternative.html">Teachable</a>
							</li>
							<li>
								<a href="thinkific-alternative.html">Thinkific</a>
							</li>
							<li>
								<a href="udemy-alternative.html">Udemy</a>
							</li>
						</ul>
					</div>
					<div class='col-sm-2 mt6-xs'>
						<h6 class='h-bold'>Help</h6>
						<ul class='list-unstyled'>
							<li>
								<a target="_blank" href="http://help.withcoach.com/">Support</a>
							</li>
							<li>
								<a href="mailto:hello@withcoach.com">Email us</a>
							</li>
							<li>
								<a href="privacy.html">Privacy</a>
							</li>
							<li>
								<a href="terms.html">Terms</a>
							</li>
						</ul>
					</div>
				</div>
				<div class='row'>
					<div class='col-sm-12'>
						<p class='text-center footer-copyright'>
							&copy; 2017 With Coach. All Rights Reserved.
						</p>
					</div>
				</div>
			</div>
		</footer>

		<!-- Used to silently record email addresses in Google Docs -->
		<script>
			var submitted = false;
			var email = '';
			var page = '';
			var form = '';
		</script>
		<iframe id='hidden_iframe' name='hidden_iframe' onload='if(submitted){window.location=&#39;https://www.withcoach.com/signup?email=&#39;+email+&#39;&amp;page=&#39;+page+&#39;&amp;form=&#39;+form;}' style='display:none;'></iframe>

		

		<script src="assets/marketing-0948a2250891d0efe03f50eeae0aa3e151bd3e6acc95e12833dca565339a4173.js" data-turbolinks-track="true"></script>
		<script id="IntercomSettingsScriptTag">
			window.intercomSettings = {
				"app_id": "heeb19fp"
			};
			(function() {
				var w = window;
				var ic = w.Intercom;
				if(typeof ic === "function") {
					ic('reattach_activator');
					ic('update', intercomSettings);
				} else {
					var d = document;
					var i = function() {
						i.c(arguments)
					};
					i.q = [];
					i.c = function(args) {
						i.q.push(args)
					};
					w.Intercom = i;

					function l() {
						var s = d.createElement('script');
						s.type = 'text/javascript';
						s.async = true;
						s.src = 'https://widget.intercom.io/widget/heeb19fp';
						var x = d.getElementsByTagName('script')[0];
						x.parentNode.insertBefore(s, x);
					}
					if(w.attachEvent) {
						w.attachEvent('onload', l);
					} else {
						w.addEventListener('load', l, false);
					}
				};
			})()
		</script>
	</body>

</html>