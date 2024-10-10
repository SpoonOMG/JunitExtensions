package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import framework.qa.models.requestData.OmniRequestMeta;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import java.util.Objects;

public abstract class OmniRequest<T> {
    private final  @NotNull OmniRequestMeta meta;
    @Nullable
    @JsonInclude(Include.NON_NULL)
    private final  OmniRequestMeta data;

    protected OmniRequest(@NotNull OmniRequestMeta meta, @NotNull OmniRequestMeta data) {
        this.meta = meta;
        this.data = data;
    }

    protected OmniRequest(@NotNull OmniRequestMeta meta) {
        this.meta = meta;
        this.data = null;
    }

    public final @NotNull OmniRequestMeta getMeta() {
        return this.meta;
    }

    @Nullable
    protected OmniRequestMeta getData() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof OmniRequest)) {
            return false;
        } else {
            OmniRequest<?> that = (OmniRequest)o;
            return Objects.equals(this.getMeta(), that.getMeta()) && Objects.equals(this.getData(), that.getData());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getMeta(), this.getData()});
    }
}
