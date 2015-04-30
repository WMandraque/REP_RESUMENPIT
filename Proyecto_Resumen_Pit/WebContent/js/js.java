package D:\GIT_Repositorios\REP_RESUMENPIT\Proyecto_Resumen_Pit\WebContent\js\ww;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for D:\GIT_Repositorios\REP_RESUMENPIT\Proyecto_Resumen_Pit\WebContent\js\ww.js.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class js extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public js(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected js(Object ...args){
        super(args);
    }

    public js() {
        super();
    }

    @AJavaOnly
    public static final NativeJsTypeRef<js> prototype = NativeJsTypeRef.get(js.class);
}