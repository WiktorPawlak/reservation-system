package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.repository.ReservationsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationsService {
  private static final int PAGE_SIZE = 4;
  private final ReservationsRepository reservationsRepository;

  public List<Reservations> getReservations(int page) {
    return reservationsRepository.findAllReservations(PageRequest.of(page, PAGE_SIZE));
  }

  public Reservations getSingleReservation(long id) {
    return reservationsRepository.findById(id)
            .orElseThrow();
  }

//  public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
//    List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
//            Sort.by(sort, "id")
//    ));
//    List<Long> ids = allPosts.stream()
//            .map(Post::getId)
//            .collect(Collectors.toList());
//    List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
//    allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
//    return allPosts;
//  }
//
//  private List<Comment> extractComments(List<Comment> comments, long id) {
//    return comments.stream()
//            .filter(comment -> comment.getPostId() == id)
//            .collect(Collectors.toList());
//  }
}
