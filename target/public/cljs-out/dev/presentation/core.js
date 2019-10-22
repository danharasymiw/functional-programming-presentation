// Compiled by ClojureScript 1.10.520 {}
goog.provide('presentation.core');
goog.require('cljs.core');
goog.require('clojure.string');
goog.require('goog.dom');
goog.require('hiccups.runtime');
goog.require('presentation.slides');
presentation.core.options = cljs.core.clj__GT_js.call(null,new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"controls","controls",1340701452),true,new cljs.core.Keyword(null,"progress","progress",244323547),true,new cljs.core.Keyword(null,"transition","transition",765692007),"fade",new cljs.core.Keyword(null,"slideNumber","slideNumber",1553611975),false,new cljs.core.Keyword(null,"dependencies","dependencies",1108064605),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"src","src",-1651076051),"node_modules/reveal.js/plugin/notes/notes.js",new cljs.core.Keyword(null,"async","async",1050769601),true], null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"src","src",-1651076051),"node_modules/reveal.js/plugin/highlight/highlight.js",new cljs.core.Keyword(null,"async","async",1050769601),true], null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"src","src",-1651076051),"node_modules/reveal.js/plugin/zoom-js/zoom.js",new cljs.core.Keyword(null,"async","async",1050769601),true], null)], null)], null));
/**
 * Get list of all slides and convert them to html strings.
 */
presentation.core.convert = (function presentation$core$convert(){
var slides = presentation.slides.all.call(null);
return clojure.string.join.call(null,cljs.core.map.call(null,((function (slides){
return (function (p1__14132_SHARP_){
return cljs.core.str.cljs$core$IFn$_invoke$arity$1(hiccups.runtime.render_html.call(null,p1__14132_SHARP_));
});})(slides))
,slides));
});
/**
 * Get all slides, set them as innerHTML and reinitialize Reveal.js
 */
presentation.core.main = (function presentation$core$main(){
goog.dom.getElement("slides").innerHTML = presentation.core.convert.call(null);

Reveal.initialize(presentation.core.options);

return Reveal.setState(Reveal.getState());
});
presentation.core.main.call(null);

//# sourceMappingURL=core.js.map
