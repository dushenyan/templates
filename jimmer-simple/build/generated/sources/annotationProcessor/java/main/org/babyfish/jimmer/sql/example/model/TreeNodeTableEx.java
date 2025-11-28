package org.babyfish.jimmer.sql.example.model;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.impl.base.BaseTableOwner;
import org.babyfish.jimmer.sql.ast.impl.base.BaseTableSymbol;
import org.babyfish.jimmer.sql.ast.impl.base.BaseTableSymbols;
import org.babyfish.jimmer.sql.ast.impl.table.JWeakJoinLambdaFactory;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.impl.table.TableProxies;
import org.babyfish.jimmer.sql.ast.impl.table.WeakJoinHandle;
import org.babyfish.jimmer.sql.ast.impl.table.WeakJoinLambda;
import org.babyfish.jimmer.sql.ast.table.BaseTable;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.ast.table.WeakJoin;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;
import org.babyfish.jimmer.sql.ast.table.spi.TableExProxy;
import org.babyfish.jimmer.sql.ast.table.spi.TableLike;

@GeneratedBy(
        type = TreeNode.class
)
public class TreeNodeTableEx extends TreeNodeTable implements TableExProxy<TreeNode, TreeNodeTable> {
    public static final TreeNodeTableEx $ = new TreeNodeTableEx(TreeNodeTable.$, (String)null);

    public TreeNodeTableEx() {
        super();
    }

    public TreeNodeTableEx(AbstractTypedTable.DelayedOperation<TreeNode> delayedOperation) {
        super(delayedOperation);
    }

    public TreeNodeTableEx(TableImplementor<TreeNode> table) {
        super(table);
    }

    protected TreeNodeTableEx(TreeNodeTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    protected TreeNodeTableEx(TreeNodeTable base, BaseTableOwner baseTableOwner) {
        super(base, baseTableOwner);
    }

    public TreeNodeTableEx parent() {
        __beforeJoin();
        if (raw != null) {
            return new TreeNodeTableEx(raw.joinImplementor(TreeNodeProps.PARENT.unwrap()));
        }
        return new TreeNodeTableEx(joinOperation(TreeNodeProps.PARENT.unwrap()));
    }

    public TreeNodeTableEx parent(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new TreeNodeTableEx(raw.joinImplementor(TreeNodeProps.PARENT.unwrap(), joinType));
        }
        return new TreeNodeTableEx(joinOperation(TreeNodeProps.PARENT.unwrap(), joinType));
    }

    public TreeNodeTableEx childNodes() {
        __beforeJoin();
        if (raw != null) {
            return new TreeNodeTableEx(raw.joinImplementor(TreeNodeProps.CHILD_NODES.unwrap()));
        }
        return new TreeNodeTableEx(joinOperation(TreeNodeProps.CHILD_NODES.unwrap()));
    }

    public TreeNodeTableEx childNodes(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new TreeNodeTableEx(raw.joinImplementor(TreeNodeProps.CHILD_NODES.unwrap(), joinType));
        }
        return new TreeNodeTableEx(joinOperation(TreeNodeProps.CHILD_NODES.unwrap(), joinType));
    }

    @Override
    public Predicate childNodes(Function<TreeNodeTableEx, Predicate> block) {
        return exists(TreeNodeProps.CHILD_NODES.unwrap(), block);
    }

    @Override
    public TreeNodeTableEx asTableEx() {
        return this;
    }

    @Override
    public TreeNodeTableEx __disableJoin(String reason) {
        return new TreeNodeTableEx(this, reason);
    }

    @Override
    public TreeNodeTableEx __baseTableOwner(BaseTableOwner baseTableOwner) {
        return new TreeNodeTableEx(this, baseTableOwner);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<TreeNodeTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>, WJ extends WeakJoin<TreeNodeTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }

    public <TT extends Table<?>> TT weakJoin(Class<TT> targetTableType,
            WeakJoin<TreeNodeTable, TT> weakJoinLambda) {
        return weakJoin(targetTableType, JoinType.INNER, weakJoinLambda);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>> TT weakJoin(Class<TT> targetTableType, JoinType joinType,
            WeakJoin<TreeNodeTable, TT> weakJoinLambda) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(targetTableType, joinType, weakJoinLambda));
        }
        return (TT)TableProxies.fluent(joinOperation(targetTableType, joinType, weakJoinLambda));
    }

    public <TT extends BaseTable> TT weakJoin(TT targetBaseTable,
            WeakJoin<TreeNodeTable, TT> weakJoinLambda) {
        return weakJoin(targetBaseTable, JoinType.INNER, weakJoinLambda);
    }

    public <TT extends BaseTable> TT weakJoin(TT targetBaseTable, JoinType joinType,
            WeakJoin<TreeNodeTable, TT> weakJoinLambda) {
        WeakJoinLambda lambda = JWeakJoinLambdaFactory.get(weakJoinLambda);
        WeakJoinHandle handle = WeakJoinHandle.of(
            lambda,
            true,
            true,
            (WeakJoin<TableLike<?>, TableLike<?>>)(WeakJoin<?, ?>) weakJoinLambda
        );
        return (TT) BaseTableSymbols.of((BaseTableSymbol) targetBaseTable, this, handle, joinType);
    }
}
