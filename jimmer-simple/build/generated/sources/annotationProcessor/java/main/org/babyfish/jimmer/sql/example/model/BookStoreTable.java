package org.babyfish.jimmer.sql.example.model;

import java.lang.Deprecated;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.base.BaseTableOwner;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = BookStore.class
)
public class BookStoreTable extends AbstractTypedTable<BookStore> implements BookStoreProps {
    public static final BookStoreTable $ = new BookStoreTable();

    public BookStoreTable() {
        super(BookStore.class);
    }

    public BookStoreTable(AbstractTypedTable.DelayedOperation<BookStore> delayedOperation) {
        super(BookStore.class, delayedOperation);
    }

    public BookStoreTable(TableImplementor<BookStore> table) {
        super(table);
    }

    protected BookStoreTable(BookStoreTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    protected BookStoreTable(BookStoreTable base, BaseTableOwner baseTableOwner) {
        super(base, baseTableOwner);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(BookStoreProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str name() {
        return __get(BookStoreProps.NAME.unwrap());
    }

    @Override
    public PropExpression.Str website() {
        return __get(BookStoreProps.WEBSITE.unwrap());
    }

    @Override
    public Predicate books(Function<BookTableEx, Predicate> block) {
        return exists(BookStoreProps.BOOKS.unwrap(), block);
    }

    @Override
    public BookStoreTableEx asTableEx() {
        return new BookStoreTableEx(this, (String)null);
    }

    @Override
    public BookStoreTable __disableJoin(String reason) {
        return new BookStoreTable(this, reason);
    }

    @Override
    public BookStoreTable __baseTableOwner(BaseTableOwner baseTableOwner) {
        return new BookStoreTable(this, baseTableOwner);
    }

    @GeneratedBy(
            type = BookStore.class
    )
    public static class Remote extends AbstractTypedTable<BookStore> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(BookStore.class, delayedOperation);
        }

        public Remote(TableImplementor<BookStore> table) {
            super(table);
        }

        public Remote(Remote base, BaseTableOwner baseTableOwner) {
            super(base, baseTableOwner);
        }

        public PropExpression.Num<Long> id() {
            return (org.babyfish.jimmer.sql.ast.PropExpression.Num<java.lang.Long>)this.<Long>get(BookStoreProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<BookStore> asTableEx() {
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
