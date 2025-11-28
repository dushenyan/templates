package org.babyfish.jimmer.sql.example.model;

import java.lang.Override;
import java.util.function.Consumer;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.ListFieldConfig;
import org.babyfish.jimmer.sql.fetcher.RecursiveListFieldConfig;
import org.babyfish.jimmer.sql.fetcher.RecursiveReferenceFieldConfig;
import org.babyfish.jimmer.sql.fetcher.ReferenceFetchType;
import org.babyfish.jimmer.sql.fetcher.ReferenceFieldConfig;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = TreeNode.class
)
public class TreeNodeFetcher extends AbstractTypedFetcher<TreeNode, TreeNodeFetcher> {
    public static final TreeNodeFetcher $ = new TreeNodeFetcher(null);

    private TreeNodeFetcher(FetcherImpl<TreeNode> base) {
        super(TreeNode.class, base);
    }

    private TreeNodeFetcher(TreeNodeFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private TreeNodeFetcher(TreeNodeFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static TreeNodeFetcher $from(Fetcher<TreeNode> base) {
        return base instanceof TreeNodeFetcher ? 
        	(TreeNodeFetcher)base : 
        	new TreeNodeFetcher((FetcherImpl<TreeNode>)base);
    }

    @NewChain
    public TreeNodeFetcher name() {
        return add("name");
    }

    @NewChain
    public TreeNodeFetcher name(boolean enabled) {
        return enabled ? add("name") : remove("name");
    }

    @NewChain
    public TreeNodeFetcher parent() {
        return add("parent");
    }

    @NewChain
    public TreeNodeFetcher parent(boolean enabled) {
        return enabled ? add("parent") : remove("parent");
    }

    @NewChain
    public TreeNodeFetcher parent(Fetcher<TreeNode> childFetcher) {
        return add("parent", childFetcher);
    }

    @NewChain
    public TreeNodeFetcher parent(IdOnlyFetchType idOnlyFetchType) {
        return add("parent", idOnlyFetchType);
    }

    @NewChain
    public TreeNodeFetcher parent(Fetcher<TreeNode> childFetcher,
            Consumer<ReferenceFieldConfig<TreeNode, TreeNodeTable>> fieldConfig) {
        return add("parent", childFetcher, fieldConfig);
    }

    @NewChain
    public TreeNodeFetcher parent(ReferenceFetchType fetchType, Fetcher<TreeNode> childFetcher) {
        return parent(childFetcher, cfg -> cfg.fetchType(fetchType));
    }

    @NewChain
    public TreeNodeFetcher recursiveParent() {
        return addRecursion("parent", null);
    }

    @NewChain
    public TreeNodeFetcher recursiveParent(
            Consumer<RecursiveReferenceFieldConfig<TreeNode, TreeNodeTable>> fieldConfig) {
        return addRecursion("parent", fieldConfig);
    }

    @NewChain
    public TreeNodeFetcher childNodes() {
        return add("childNodes");
    }

    @NewChain
    public TreeNodeFetcher childNodes(boolean enabled) {
        return enabled ? add("childNodes") : remove("childNodes");
    }

    @NewChain
    public TreeNodeFetcher childNodes(Fetcher<TreeNode> childFetcher) {
        return add("childNodes", childFetcher);
    }

    @NewChain
    public TreeNodeFetcher childNodes(Fetcher<TreeNode> childFetcher,
            Consumer<ListFieldConfig<TreeNode, TreeNodeTable>> fieldConfig) {
        return add("childNodes", childFetcher, fieldConfig);
    }

    @NewChain
    public TreeNodeFetcher recursiveChildNodes() {
        return addRecursion("childNodes", null);
    }

    @NewChain
    public TreeNodeFetcher recursiveChildNodes(
            Consumer<RecursiveListFieldConfig<TreeNode, TreeNodeTable>> fieldConfig) {
        return addRecursion("childNodes", fieldConfig);
    }

    @Override
    protected TreeNodeFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new TreeNodeFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected TreeNodeFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new TreeNodeFetcher(this, prop, fieldConfig);
    }
}
