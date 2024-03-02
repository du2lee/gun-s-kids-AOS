package com.ehyundai.project.domain.usecase.Club

import com.ehyundai.project.domain.model.Club
import com.ehyundai.project.domain.repository.ClubRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetClubsUseCase @Inject constructor(private val repository: ClubRepository) {
    operator fun invoke(): Flowable<List<Club>> = repository.getSearchMovies()
}