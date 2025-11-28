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
        type = Author.class
)
public class AuthorTableEx extends AuthorTable implements TableExProxy<Author, AuthorTable> {
    public static final AuthorTableEx $ = new AuthorTableEx(AuthorTable.$, (String)null);

    public AuthorTableEx() {
        super();
    }

    public AuthorTableEx(AbstractTypedTable.DelayedOperation<Author> delayedOperation) {
        super(delayedOperation);
    }

    public AuthorTableEx(TableImplementor<Author> table) {
        super(table);
    }

    protected AuthorTableEx(AuthorTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    protected AuthorTableEx(AuthorTable base, BaseTableOwner baseTableOwner) {
        super(base, baseTableOwner);
    }

    public BookTableEx books() {
        __beforeJoin();
        if (raw != null) {
            return new BookTableEx(raw.joinImplementor(AuthorProps.BOOKS.unwrap()));
        }
        return new BookTableEx(joinOperation(AuthorProps.BOOKS.unwrap()));
    }

    public BookTableEx books(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new BookTableEx(raw.joinImplementor(AuthorProps.BOOKS.unwrap(), joinType));
        }
        return new BookTableEx(joinOperation(AuthorProps.BOOKS.unwrap(), joinType));
    }

    @Override
    public Predicate books(Function<BookTableEx, Predicate> block) {
        return exists(AuthorProps.BOOKS.unwrap(), block);
    }

    @Override
    public AuthorTableEx asTableEx() {
        return this;
    }

    @Override
    public AuthorTableEx __disableJoin(String reason) {
        return new AuthorTableEx(this, reason);
    }

    @Override
    public AuthorTableEx __baseTableOwner(BaseTableOwner baseTableOwner) {
        return new AuthorTableEx(this, baseTableOwner);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<AuthorTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>, WJ extends WeakJoin<AuthorTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }

    public <TT extends Table<?>> TT weakJoin(Class<TT> targetTableType,
            WeakJoin<AuthorTable, TT> weakJoinLambda) {
        return weakJoin(targetTableType, JoinType.INNER, weakJoinLambda);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>> TT weakJoin(Class<TT> targetTableType, JoinType joinType,
            WeakJoin<AuthorTable, TT> weakJoinLambda) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(targetTableType, joinType, weakJoinLambda));
        }
        return (TT)TableProxies.fluent(joinOperation(targetTableType, joinType, weakJoinLambda));
    }

    public <TT extends BaseTable> TT weakJoin(TT targetBaseTable,
            WeakJoin<AuthorTable, TT> weakJoinLambda) {
        return weakJoin(targetBaseTable, JoinType.INNER, weakJoinLambda);
    }

    public <TT extends BaseTable> TT weakJoin(TT targetBaseTable, JoinType joinType,
            WeakJoin<AuthorTable, TT> weakJoinLambda) {
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
