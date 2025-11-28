package org.babyfish.jimmer.sql.example.model;

import java.lang.Deprecated;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.base.BaseTableOwner;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = TreeNode.class
)
public class TreeNodeTable extends AbstractTypedTable<TreeNode> implements TreeNodeProps {
    public static final TreeNodeTable $ = new TreeNodeTable();

    public TreeNodeTable() {
        super(TreeNode.class);
    }

    public TreeNodeTable(AbstractTypedTable.DelayedOperation<TreeNode> delayedOperation) {
        super(TreeNode.class, delayedOperation);
    }

    public TreeNodeTable(TableImplementor<TreeNode> table) {
        super(table);
    }

    protected TreeNodeTable(TreeNodeTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    protected TreeNodeTable(TreeNodeTable base, BaseTableOwner baseTableOwner) {
        super(base, baseTableOwner);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(TreeNodeProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str name() {
        return __get(TreeNodeProps.NAME.unwrap());
    }

    @Override
    public TreeNodeTable parent() {
        __beforeJoin();
        if (raw != null) {
            return new TreeNodeTable(raw.joinImplementor(TreeNodeProps.PARENT.unwrap()));
        }
        return new TreeNodeTable(joinOperation(TreeNodeProps.PARENT.unwrap()));
    }

    @Override
    public TreeNodeTable parent(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new TreeNodeTable(raw.joinImplementor(TreeNodeProps.PARENT.unwrap(), joinType));
        }
        return new TreeNodeTable(joinOperation(TreeNodeProps.PARENT.unwrap(), joinType));
    }

    @Override
    public PropExpression.Num<Long> parentId() {
        return __getAssociatedId(TreeNodeProps.PARENT.unwrap());
    }

    @Override
    public Predicate childNodes(Function<TreeNodeTableEx, Predicate> block) {
        return exists(TreeNodeProps.CHILD_NODES.unwrap(), block);
    }

    @Override
    public TreeNodeTableEx asTableEx() {
        return new TreeNodeTableEx(this, (String)null);
    }

    @Override
    public TreeNodeTable __disableJoin(String reason) {
        return new TreeNodeTable(this, reason);
    }

    @Override
    public TreeNodeTable __baseTableOwner(BaseTableOwner baseTableOwner) {
        return new TreeNodeTable(this, baseTableOwner);
    }

    @GeneratedBy(
            type = TreeNode.class
    )
    public static class Remote extends AbstractTypedTable<TreeNode> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(TreeNode.class, delayedOperation);
        }

        public Remote(TableImplementor<TreeNode> table) {
            super(table);
        }

        public Remote(Remote base, BaseTableOwner baseTableOwner) {
            super(base, baseTableOwner);
        }

        public PropExpression.Num<Long> id() {
            return (org.babyfish.jimmer.sql.ast.PropExpression.Num<java.lang.Long>)this.<Long>get(TreeNodeProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<TreeNode> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }

        @Override
        public Remote __baseTableOwner(BaseTableOwner baseTableOwner) {
            return new Remote(this, baseTableOwner);
        }
    }
}
