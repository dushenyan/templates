package org.babyfish.jimmer.sql.example.model;

import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
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
        type = Book.class
)
public class BookTable extends AbstractTypedTable<Book> implements BookProps {
    public static final BookTable $ = new BookTable();

    public BookTable() {
        super(Book.class);
    }

    public BookTable(AbstractTypedTable.DelayedOperation<Book> delayedOperation) {
        super(Book.class, delayedOperation);
    }

    public BookTable(TableImplementor<Book> table) {
        super(table);
    }

    protected BookTable(BookTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    protected BookTable(BookTable base, BaseTableOwner baseTableOwner) {
        super(base, baseTableOwner);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(BookProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str name() {
        return __get(BookProps.NAME.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> edition() {
        return __get(BookProps.EDITION.unwrap());
    }

    @Override
    public PropExpression.Num<BigDecimal> price() {
        return __get(BookProps.PRICE.unwrap());
    }

    @Override
    public BookStoreTable store() {
        __beforeJoin();
        if (raw != null) {
            return new BookStoreTable(raw.joinImplementor(BookProps.STORE.unwrap()));
        }
        return new BookStoreTable(joinOperation(BookProps.STORE.unwrap()));
    }

    @Override
    public BookStoreTable store(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new BookStoreTable(raw.joinImplementor(BookProps.STORE.unwrap(), joinType));
        }
        return new BookStoreTable(joinOperation(BookProps.STORE.unwrap(), joinType));
    }

    @Override
    public PropExpression.Num<Long> storeId() {
        return __getAssociatedId(BookProps.STORE.unwrap());
    }

    @Override
    public Predicate authors(Function<AuthorTableEx, Predicate> block) {
        return exists(BookProps.AUTHORS.unwrap(), block);
    }

    @Override
    public BookTableEx asTableEx() {
        return new BookTableEx(this, (String)null);
    }

    @Override
    public BookTable __disableJoin(String reason) {
        return new BookTable(this, reason);
    }

    @Override
    public BookTable __baseTableOwner(BaseTableOwner baseTableOwner) {
        return new BookTable(this, baseTableOwner);
    }

    @GeneratedBy(
            type = Book.class
    )
    public static class Remote extends AbstractTypedTable<Book> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(Book.class, delayedOperation);
        }

        public Remote(TableImplementor<Book> table) {
            super(table);
        }

        public Remote(Remote base, BaseTableOwner baseTableOwner) {
            super(base, baseTableOwner);
        }

        public PropExpression.Num<Long> id() {
            return (org.babyfish.jimmer.sql.ast.PropExpression.Num<java.lang.Long>)this.<Long>get(BookProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<Book> asTableEx() {
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
