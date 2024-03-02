package com.ehyundai.project.data.repository.search

import com.ehyundai.project.data.mapper.mapperToClub
import com.ehyundai.project.data.repository.search.local.ClubLocalDataSource
import com.ehyundai.project.data.repository.search.remote.ClubRemoteDataSource
import com.ehyundai.project.domain.model.Club
import com.ehyundai.project.domain.repository.ClubRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class ClubRepositoryImpl @Inject constructor(
    private val clubLocalDataSource: ClubLocalDataSource,
    private val clubRemoteDataSource: ClubRemoteDataSource
): ClubRepository{
    override fun getSearchMovies(): Flowable<List<Club>> {
        return clubLocalDataSource.getAllClubs()
            .onErrorReturn { listOf() }
            .flatMapPublisher { localClubs ->
                if(localClubs.isEmpty()) {
                    getRemoteSearchMovies()
                        .toFlowable()
                        .onErrorReturn { listOf() }
                } else {
                    val local = Single.just(mapperToClub(localClubs))
                    val remote = getRemoteSearchMovies()
                        .onErrorResumeNext { local }
                    Single.concat(local, remote)
                }
            }
    }

    override fun getRemoteSearchMovies(): Single<List<Club>> {
        return clubRemoteDataSource.getSearchClubs()
            .flatMap {
                // insertClubs 는 ClubEntity 로 localDB에 insert.
                // andThen 연산자를 통해 localDB에 insert 한 Data 들을 Mapper 클래스를 사용하여 Club type 으로 mapping 하고 해당 list 를 return
                clubLocalDataSource.insertClubs(it.data).
                        andThen(Single.just(mapperToClub(it.data)))
            }
    }
}